import java.util.Scanner;

// Candidate.java
class Candidate {

    private String name;
    private double percentage;
    private int backlogs;
    private int graduationYear;
    private String[] skills;

    public Candidate(String name, double percentage, int backlogs,
            int graduationYear, String[] skills) {
        this.name = name;
        this.percentage = percentage;
        this.backlogs = backlogs;
        this.graduationYear = graduationYear;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public boolean hasSkills(String requiredSkills) {
        for (int i = 0; i < skills.length; i++) {
            if (skills[i].equalsIgnoreCase(requiredSkills)) {
                return true;
            }
        }
        return false;
    }
}

// EligibilityRule.java
abstract class EligibilityRule {

    public abstract String getRuleName();

    public abstract boolean check(Candidate candidate, Job job);
}

// PercentageRule.java
class PercentageRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "Percentage";
    }

    @Override
    public boolean check(Candidate candidate, Job job) {
        return candidate.getPercentage() >= job.getMinimumPercentage();
    }
}

// BacklogRule.java
class BacklogRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "Backlogs";
    }

    @Override
    public boolean check(Candidate candidate, Job job) {
        return candidate.getBacklogs() <= job.getMaximumBacklogs();
    }
}

// GraduationYearRule.java
class GraduationYearRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "Graduation Year";
    }

    @Override
    public boolean check(Candidate candidate, Job job) {
        return candidate.getGraduationYear() == job.getRequiredGraduationYear();
    }
}

// SkillRule.java
class SkillRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "Skills";
    }

    @Override
    public boolean check(Candidate candidate, Job job) {

        String[] requiredSkills = job.getRequiredSkills();

        for (int i = 0; i < requiredSkills.length; i++) {
            if (!candidate.hasSkills(requiredSkills[i])) {
                return false;
            }
        }

        return true;
    }
}

// Job.java
class Job {

    private String company;
    private String role;
    private double minimumPercentage;
    private int maximumBacklogs;
    private int requiredGraduationYear;
    private String[] requiredSkills;

    public Job(String company, String role, double minimumPercentage,
            int maximumBacklogs, int requiredGraduationYear,
            String[] requiredSkills) {

        this.company = company;
        this.role = role;
        this.minimumPercentage = minimumPercentage;
        this.maximumBacklogs = maximumBacklogs;
        this.requiredGraduationYear = requiredGraduationYear;
        this.requiredSkills = requiredSkills;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public double getMinimumPercentage() {
        return minimumPercentage;
    }

    public int getMaximumBacklogs() {
        return maximumBacklogs;
    }

    public int getRequiredGraduationYear() {
        return requiredGraduationYear;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }
}

// EligibilityChecker.java
class EligibilityChecker {

    private EligibilityRule[] rules;

    public EligibilityChecker() {

        rules = new EligibilityRule[] {
                new PercentageRule(),
                new BacklogRule(),
                new GraduationYearRule(),
                new SkillRule()
        };
    }

    public boolean evaluate(Candidate candidate, Job job) {

        boolean eligible = true;

        for (int i = 0; i < rules.length; i++) {

            boolean passed = rules[i].check(candidate, job);

            if (passed) {
                System.out.println(rules[i].getRuleName() + " : PASS");
            } else {
                System.out.println(rules[i].getRuleName() + " : FAIL");
                eligible = false;
            }
        }

        return eligible;
    }
}

// Main.java
public class Placement_eligibility_engine_oneshot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       PLACEMENT ELIGIBILITY CHECKER");
        System.out.println("========================================");

        // Candidate Details

        System.out.println("\nEnter Candidate Name: ");
        String name = scanner.next();

        System.out.println("Enter Candidate Percentage: ");
        double percentage = scanner.nextDouble();

        System.out.println("Enter Number of Active Backlogs: ");
        int backlogs = scanner.nextInt();

        System.out.println("Enter Candidate Graduation Year: ");
        int graduationYear = scanner.nextInt();

        System.out.println("Enter Number of Skills Candidate Has: ");
        int skillCount = scanner.nextInt();

        String[] skills = new String[skillCount];

        System.out.println("Enter Candidate Skills:");

        for (int i = 0; i < skillCount; i++) {
            System.out.println("Enter Skill " + (i + 1) + ": ");
            skills[i] = scanner.next();
        }

        Candidate candidate = new Candidate(
                name, percentage, backlogs, graduationYear, skills);

        // Job Details

        System.out.println("\nEnter Number of Available Jobs: ");
        int jobCount = scanner.nextInt();

        if (jobCount <= 0) {
            System.out.println("No jobs available.");
            scanner.close();
            return;
        }

        Job[] jobs = new Job[jobCount];

        for (int i = 0; i < jobCount; i++) {

            System.out.println("\n========== JOB " + (i + 1) + " DETAILS ==========");

            System.out.println("Enter Company Name: ");
            String company = scanner.next();

            System.out.println("Enter Job Role: ");
            String role = scanner.next();

            System.out.println("Enter Minimum Percentage Required: ");
            double minimumPercentage = scanner.nextDouble();

            System.out.println("Enter Maximum Backlogs Allowed: ");
            int maximumBacklogs = scanner.nextInt();

            System.out.println("Enter Required Graduation Year: ");
            int requiredGraduationYear = scanner.nextInt();

            System.out.println("Enter Number of Required Skills: ");
            int requiredSkillCount = scanner.nextInt();

            String[] requiredSkills = new String[requiredSkillCount];

            System.out.println("Enter Required Skills:");

            for (int j = 0; j < requiredSkillCount; j++) {
                System.out.println("Enter Required Skill " + (j + 1) + ": ");
                requiredSkills[j] = scanner.next();
            }

            jobs[i] = new Job(
                    company,
                    role,
                    minimumPercentage,
                    maximumBacklogs,
                    requiredGraduationYear,
                    requiredSkills);
        }

        // Display Available Jobs

        System.out.println("\n========================================");
        System.out.println("             AVAILABLE JOBS");
        System.out.println("========================================");

        for (int i = 0; i < jobs.length; i++) {
            System.out.println((i + 1) + ". " +
                    jobs[i].getCompany() + " - " + jobs[i].getRole());
        }

        // Job Selection

        System.out.println("\nEnter the Job Number You Want to Apply For: ");
        int selectedJobNumber = scanner.nextInt();

        if (selectedJobNumber < 1 || selectedJobNumber > jobCount) {
            System.out.println("Invalid Job Selection!");
            scanner.close();
            return;
        }

        Job selectedJob = jobs[selectedJobNumber - 1];

        // Eligibility Evaluation

        EligibilityChecker checker = new EligibilityChecker();

        System.out.println("\n========================================");
        System.out.println("       PLACEMENT ELIGIBILITY RESULT");
        System.out.println("========================================");

        System.out.println("Candidate : " + candidate.getName());
        System.out.println("Company   : " + selectedJob.getCompany());
        System.out.println("Role      : " + selectedJob.getRole());

        System.out.println("----------------------------------------");
        System.out.println("        ELIGIBILITY RULES");
        System.out.println("----------------------------------------");

        boolean eligible = checker.evaluate(candidate, selectedJob);

        System.out.println("----------------------------------------");

        if (eligible) {
            System.out.println("Final Result : ELIGIBLE");
            System.out.println("Congratulations! You are eligible for this job.");
        } else {
            System.out.println("Final Result : NOT ELIGIBLE");
            System.out.println("Sorry! You do not meet all the job requirements.");
        }

        System.out.println("========================================");

        scanner.close();
    }
}
