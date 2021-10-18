import javax.swing.text.StyleContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

interface comm
{
     void view_comments();
}
class COMMENTS
{
    String s;
    COMMENTS(String comm)
    {
        this.s=comm;
    }
}


interface Viewing
{
     void view_materials();
     void view_assessments();
}

class instructor implements Viewing,comm
{
    private ArrayList<slides> lecture_slides;
    private ArrayList<video>lecture_videos;
    private ArrayList<Assignment> assignments;
    private ArrayList<Quiz> quiz;


    void get_array_lists(ArrayList<slides> lecture_slides,ArrayList<video>lecture_videos)
    {
        this.lecture_slides=lecture_slides;
        this.lecture_videos=lecture_videos;
    }

    void get_assessment_lists( ArrayList<Assignment> assignments,ArrayList<Quiz> quiz)
    {
        this.assignments=assignments;
        this.quiz=quiz;
    }

    public void view_materials() {

        for (int i = 0; i < lecture_slides.size(); i++) {
            System.out.println(lecture_slides.get(i).getTopic());
            System.out.println(lecture_slides.get(i).getContent());
            System.out.println(lecture_slides.get(i).getDate());
        }

        for (int i = 0; i < lecture_videos.size(); i++) {
            System.out.println(lecture_videos.get(i).getContent());
            System.out.println(lecture_videos.get(i).getTopic());
            System.out.println(lecture_videos.get(i).getDate());
        }
    }



    public void grade_assessments()
    {

    }




    @Override
    public void view_comments() {

    }

    @Override
    public void view_assessments() {
        for(int i=0;i<assignments.size();i++)
        {
            System.out.println(assignments.get(i).getProblem_statement());
            System.out.println(assignments.get(i).getMarks());
        }
        for(int i=0;i< quiz.size();i++)
        {
            System.out.println(quiz.get(i).getQuestion());
        }

    }
}




class slides
{


    private String topic;
    private ArrayList<String> content;
    private Date date;
     private String uploader;
    slides(String topic,ArrayList<String> content,String upload)
    {
        this.topic=topic;
        this.content=content;
        this.uploader=upload;
        this.date=java.util.Calendar.getInstance().getTime();
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public String getUploader() {
        return uploader;
    }
}
class video
{
    private String topic;
    private String content;
    private String uploader;
    private Date date;
    video(String topic,String content,String uploader)
    {
        this.topic=topic;
        this.uploader=uploader;
        this.content=content;
        this.date=java.util.Calendar.getInstance().getTime();
    }

    public String getUploader() {
        return uploader;
    }

    public String getTopic() {
        return topic;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

}
class Assignment
{

    private String name;
    private String problem_statement;
    private int marks;
    private String status;
    private int graded;
    public Assignment(String statement, int marks,String status) {
        this.marks=marks;
        this.problem_statement=statement;
        this.status=status;
        this.graded=-1;
        this.name="";
    }

    public String getName() {
        return name;
    }

    public int getGraded() {
        return graded;
    }

    public int getMarks() {
        return marks;
    }

    public String getProblem_statement() {
        return problem_statement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
class Quiz
{
    private String name;
    private String question;
    private int marks;
    private String status;
    private int graded;
    Quiz(String ques,int marks,String status)
    {
        this.question=ques;
        this.status=status;
        this.marks=marks;
        this.graded=-1;
        this.name="";
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public int getGraded() {
        return graded;
    }

    public String getQuestion() {
        return question;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class student implements Viewing,comm
{
    ArrayList<Assignment> assignment_student=new ArrayList<>();

    ArrayList<Quiz> student_quiz=new ArrayList<>();

    public void setAssignment_student(ArrayList<Assignment> assignment_student) {
        this.assignment_student = assignment_student;
    }
    public ArrayList<Assignment> getAssignment_student() {
        return assignment_student;
    }

    public void setStudent_quiz(ArrayList<Quiz> student_quiz) {
        this.student_quiz = student_quiz;
    }

    public ArrayList<Quiz> getQuiz_student()
    {
        return student_quiz;
    }

    public void print_grades()
    {
        System.out.println("Graded Assignments");
        for(int i=0;i<assignments.size();i++)
        {
            if(assignments.get(i).getGraded()!=-1)
            System.out.println(assignments.get(i).getName());
        }
        for(int i=0;i< quiz.size();i++)
        {
            if(quiz.get(i).getGraded()!=-1)
            System.out.println(quiz.get(i).getName());
        }

        System.out.println("Ungraded Assignments");
        for(int i=0;i<assignments.size();i++)
        {
            if(assignments.get(i).getGraded()==-1)
                System.out.println(assignments.get(i).getName());
        }
        for(int i=0;i< quiz.size();i++)
        {
            if(quiz.get(i).getGraded()==-1)
                System.out.println(quiz.get(i).getName());
        }

    }

    ArrayList<slides> lecture_slides;ArrayList<video>lecture_videos;
    ArrayList<Assignment> assignments;ArrayList<Quiz> quiz;
    void get_array_lists(ArrayList<slides> lecture_slides,ArrayList<video>lecture_videos)
    {
        this.lecture_slides=lecture_slides;
        this.lecture_videos=lecture_videos;
    }

    void get_assessment_lists( ArrayList<Assignment> assignments,ArrayList<Quiz> quiz)
    {
        this.assignments=assignments;
        this.quiz=quiz;
    }

    @Override
    public void view_comments()
    {


    }
    @Override
    public void view_materials() {

        for (int i = 0; i < lecture_slides.size(); i++) {
            System.out.println(lecture_slides.get(i).getTopic());
            System.out.println(lecture_slides.get(i).getContent());
            System.out.println(lecture_slides.get(i).getDate());
        }
        System.out.println(lecture_slides.get(0).getUploader());



        for (int i = 0; i < lecture_videos.size(); i++) {
            System.out.println(lecture_videos.get(i).getContent());
            System.out.println(lecture_videos.get(i).getTopic());
            System.out.println(lecture_videos.get(i).getTopic());
        }
        System.out.println(lecture_videos.get(0).getUploader());

    }

    @Override
    public void view_assessments()
    {
        for(int i=0;i<assignments.size();i++)
        {
            System.out.println("ID : "+i+" "+assignments.get(i).getProblem_statement());
            System.out.println("Max Marks : "+assignments.get(i).getMarks());
        }

        for(int i=0;i< quiz.size();i++)
        {
            System.out.println("Quiz "+i+" "+"Quiz question: "+quiz.get(i).getQuestion());
        }

    }
}

public class Main {

    ArrayList<slides> lecture_slides=new ArrayList<>();
    ArrayList<video> lecture_videos=new ArrayList<>();
    ArrayList<Assignment> assignment=new ArrayList<>();
    ArrayList<Quiz> quiz=new ArrayList<>();


    COMMENTS comm;
    ArrayList<COMMENTS> comments=new ArrayList<>();

    Scanner cin=new Scanner(System.in);

    public static void main(String[] args)
    {
        Main m=new Main();
        Scanner cin=new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to Backpack \n 1.Enter as Instructor \n 2.enter as Student \n 3.Exit");
            int login = cin.nextInt();

            instructor I0=new instructor();
            instructor I1=new instructor();
            student s0=new student();
            student s1=new student();
            student s2=new student();


            if (login == 1)
            {
                System.out.println("Instructors: \n 0-I0 \n 1-I1");
                System.out.println("choose ID : ");
                int ID=cin.nextInt();
                String uploader="I1";
                if(ID==0)
                {
                    uploader="I0";
                }


                while(true)
                {
                    System.out.println("INSTRUCTORS MENU \n 1. Add Class Material \n 2. Add Assessment" +
                            "\n 3. View Lecture materials \n 4. View Assessments \n 5. Grade Assessments" +
                            "\n 6. Close Assessment \n 7. View Comments \n 8.Add comments \n 9.Logout");

                    int choice=cin.nextInt();

                    if(choice==1)
                    {
                        System.out.println("1.Add Lecture Slide \n 2. Add Lecture Video");
                        int c=cin.nextInt();
                        if(c==1)
                        {
                            cin.nextLine();
                            System.out.println("Enter Topic of Slide : ");
                            String topic=cin.nextLine();
                            System.out.println("Enter The no. of Slides");
                            int num= cin.nextInt();
                            if(ID==0)
                                m.add_slides(topic,num,uploader);
                            else
                                m.add_slides(topic,num,uploader);

                            System.out.println("Welcome "+uploader);
                        }
                        else
                        {
                            cin.nextLine();
                            System.out.println("Enter Topic of Slide : ");
                            String topic=cin.nextLine();
                            System.out.println("Enter The file name");
                            String file=cin.nextLine();
                            if(ID==0)
                            m.add_video(I0,topic,file,uploader);
                            else
                                m.add_video(I1,topic,file,uploader);

                            System.out.println("Welcome "+uploader);
                        }
                    }
                    if(choice==2)
                    {
                        System.out.println("1.Add Assignment \n 2. Add Quiz");
                        int c=cin.nextInt();
                        if(c==1)
                        {
                            cin.nextLine();

                            System.out.println("Enter The problem Statement : ");
                            String statement=cin.nextLine();
                            System.out.println("Enter the Max Marks : ");
                            int marks=cin.nextInt();
                            if(ID==0)
                            m.add_assignment(I0,statement,marks);
                            else
                                m.add_assignment(I1,statement,marks);

                        }
                        else
                        {
                            cin.nextLine();

                            System.out.println("Enter the Quiz Question : ");
                            String ques=cin.nextLine();
                            if(ID==0)
                            m.add_quizzes(I0,ques);
                            else
                                m.add_quizzes(I1,ques);

                        }
                    }
                    if(choice==3)
                    {
                        m.view_material();
                    }
                    if(choice == 4)
                    {
                        m.View_assessments();
                    }
                    if(choice == 5)
                    {
                        // grade assignments
                    }
                    if(choice == 6)
                    {
                        // close the assessment
                    }
                    if(choice ==7)
                    {
                        m.view_comments();
                    }
                    if(choice ==8)
                    {
                        cin.nextLine();
                        System.out.println("Enter The comments : ");
                        String s=cin.nextLine();
                        m.add_comments(s);
                    }
                    if(choice == 9)
                    {
                        break;
                    }

                }

            }

            if (login == 2)
            {

                    System.out.println("Students : \n 0-S0 \n 1-S1 \n 2-S2");
                    int ID=cin.nextInt();
                    String stu="S2";
                    student s=s2;
                    if(ID==0)
                    {
                        stu="S0";
                        s=s0;
                    }
                    if(ID==1)
                    {
                        stu="S1";
                        s=s1;
                    }
                while(true)
                {
                    System.out.println("STUDENTS MENU \n 1.view lecture materials \n 2.view assessments \n 3.submit assessments" +
                            "\n 4. view grades \n 5. View comments \n 6.Add Comments \n 7. Logout");
                    int choice=cin.nextInt();
                    if(choice==1)
                    {
                        m.student_view_material();
                    }
                    if(choice == 2)
                    {
                        m.student_View_assessments();
                    }
                    if(choice == 3)
                    {
                        m.pending_assessments(s);
                        System.out.println("Enter ID of assignment :");
                        int a=cin.nextInt();
                        System.out.println("Enter the file name of assignment");
                        String name=cin.nextLine();
                        if(name.charAt(name.length()-1)=='p' && name.charAt(name.length()-2)=='i'
                        && name.charAt(name.length()-3)=='z' && name.charAt(name.length()-4)=='.')
                        {
                            //m.grade_assessments(a,name);
                        }
                        else
                        {
                            System.out.println("ERROR!!!!!! Wrong File name submitted");
                        }
                    }
                    if(choice == 4)
                    {
                        m.view_grades(s);
                    }
                    if(choice == 5)
                    {
                        m.view_comments();
                    }
                    if(choice==6)
                    {
                        System.out.println("Enter The comments : ");
                        String str=cin.nextLine();
                        m.add_comments(str);
                    }
                    if(choice == 7)
                    {
                        break;
                    }
                }

            }
            if (login == 3) {
                break;
            }
        }
    }


    void add_slides(String topic,int slides,String uploader)
    {
        ArrayList<String> materials=new ArrayList<String>();
        for(int j=1;j<=slides;j++) {
            System.out.println("Content in slide " + j);
            String content = cin.nextLine();
            materials.add(content);
        }
            slides s=new slides(topic,materials,uploader);
        lecture_slides.add(s);

    }
    void add_video(instructor i,String topic,String content,String uploader)
    {
        video v=new video(topic, content,uploader);
        lecture_videos.add(v);
    }
    void add_assignment( instructor i,String statement,int marks)
    {
        Assignment assi=new Assignment(statement,marks,"False");
        assignment.add(assi);
    }
    void add_quizzes( instructor i,String statement)
    {
        Quiz q=new Quiz(statement,1,"False");
        quiz.add(q);
    }
    void view_material()
    {
        instructor i=new instructor();
        i.get_array_lists(lecture_slides,lecture_videos);
        i.view_materials();

    }
    void View_assessments() {
        instructor i=new instructor();
        i.get_assessment_lists(assignment,quiz);
        i.view_assessments();
    }

    void student_view_material()
    {
        student s=new student();
        s.get_array_lists(lecture_slides,lecture_videos);
        s.view_materials();
    }
    void student_View_assessments()
    {
        student s=new student();
        s.get_assessment_lists(assignment,quiz);
        s.view_assessments();
    }


    void add_comments(String s)
    {
        comm=new COMMENTS(s);
        comments.add(comm);
    }
    void view_comments()
    {
        for(int i=0;i< comments.size();i++)
        {
            System.out.println(comments.get(i));
        }
    }
    void pending_assessments(student s)
    {
        ArrayList<Assignment> pending=s.getAssignment_student();
        for(int i=0;i< pending.size();i++)
        {
            if(pending.get(i).getStatus()=="False")
            {
                System.out.println(i+" -> "+pending.get(i).getProblem_statement());
            }
        }
        System.out.println("   Quiz  ");
        ArrayList<Quiz> pending_q=s.getQuiz_student();
        for(int i=0;i<pending_q.size();i++)
        {
            if(pending_q.get(i).getStatus()=="False")
            {
                System.out.println(i+" -> "+pending_q.get(i).getQuestion());
            }
        }


    }
    void submit_assignment(student s,int code_ass,int code_quiz)
    {
        ArrayList<Assignment> pending=s.getAssignment_student();
        for(int i=0;i< pending.size();i++)
        {
            if(i==code_ass)
            {
                pending.get(i).setStatus("True");
            }
        }
        s.setAssignment_student(pending);


        ArrayList<Quiz> q_pending=s.getQuiz_student();
        for(int i=0;i< q_pending.size();i++)
        {
            if(i==code_quiz)
            {
                q_pending.get(i).setStatus("True");
            }
        }
        s.setStudent_quiz(q_pending);
    }

    void view_grades(student s)
    {
        s.print_grades();
    }
    void get_grades()
    {
        instructor i=new instructor();
        i.view_assessments();
        System.out.println("Enter the ID of assignment to check the submission");
    }

}
