import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String studentAnsLower = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String keyword = kw.trim().toLowerCase();
            if (!keyword.isEmpty() && studentAnsLower.contains(keyword)) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) {
            return points * 0.75;
        } else if (matchedCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double overallScore = 0.0;

        // Regex to parse quoted strings and standard tokens
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            if (tokens.size() < 5) continue;

            String qType = tokens.get(0);
            String qText = tokens.get(1);
            String correctAns = tokens.get(2);
            String studentAns = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            Question question;
            switch (qType) {
                case "MCQ":
                    question = new MCQQuestion(qText, correctAns, studentAns, points);
                    break;
                case "TF":
                    question = new TFQuestion(qText, correctAns, studentAns, points);
                    break;
                case "ESSAY":
                    question = new EssayQuestion(qText, correctAns, studentAns, points);
                    break;
                default:
                    continue;
            }

            double score = question.calculateScore();
            overallScore += score;

            System.out.printf("%s: %.2f%n", qType, score);
        }

        System.out.printf("Total Score: %.2f%n", overallScore);
        scanner.close();
    }
}