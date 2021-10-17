import javax.swing.text.StyleContext;
import java.util.ArrayList;
import java.util.Scanner;



class COMMENTS
{
    String s;
    COMMENTS(String comm)
    {
        this.s=comm;
    }
}

class instructor
{
    ArrayList<material> mater=new ArrayList<>();
    ArrayList<video> video=new ArrayList<>();
    ArrayList<Assignment> assignment=new ArrayList<>();
    ArrayList<Quiz> quiz=new ArrayList<>();

    void setMater_slides(String topic,String content,String upload)
    {
        material m=new material(topic,content,upload);
        mater.add(m);
    }
    void setMater_video(String topic,String name)
    {
        video v=new video(topic,name);
        video.add(v);
    }
    void set_Assignment(String statement,int marks)
    {
        Assignment ass=new Assignment(statement,marks);
        assignment.add(ass);
    }
    void set_quizzes(String ques)
    {
        Quiz q=new Quiz(ques);
        quiz.add(q);
    }


}

class material
{
    String topic;
    String content;
    private final String uploader;
    material(String topic,String content,String upload)
    {
        this.topic=topic;
        this.content=content;
        this.uploader=upload;
    }
}
class video
{
    String topic;
    String content;
    video(String topic,String content)
    {
        this.topic=topic;
        this.content=content;
    }
}
class Assignment
{
    String problem_statement;
    int marks;

    public Assignment(String statement, int marks) {
        this.marks=marks;
        this.problem_statement=statement;

    }

}
class Quiz
{
    String question;
    int marks=1;
    Quiz(String ques)
    {
        this.question=ques;
    }

}
class student
{

}

public class Main {

    ArrayList<instructor> inst=new ArrayList<>();  // arraylist in instructors quiz assimgm ..



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

                instructor i=new instructor();
                while(true)
                {
                    System.out.println("INSTRUCTORS MENU \n 1. Add Class Material \n 2. Add Assessment" +
                            "\n 3. View Lecture materials \n 4. View Assessments \n 5. Grade Assessments" +
                            "\n 6. Close Assessment \n 7. View Comments \n 8.Add commments \n 9.Logout");

                    int choice=cin.nextInt();

                    if(choice==1)
                    {
                        System.out.println("1.Add Lecture Slide \n 2. Add Lecture Video");
                        int c=cin.nextInt();
                        if(c==1)
                        {
                            System.out.println("Enter Topic of Slide : ");
                            String topic=cin.nextLine();
                            System.out.println("Enter The no. of Slides");
                            int num= cin.nextInt();
                            m.add_slides(i,topic,num,uploader);
                            System.out.println("Welcome "+uploader);
                        }
                        else
                        {
                            System.out.println("Enter Topic of Slide : ");
                            String topic=cin.nextLine();
                            System.out.println("Enter The file name");
                            String file=cin.nextLine();
                            m.add_video(i,topic,file);
                            System.out.println("Welcome "+uploader);
                        }
                    }
                    if(choice==2)
                    {
                        System.out.println("1.Add Assignment \n 2. Add Quiz");
                        int c=cin.nextInt();
                        if(c==1)
                        {
                            System.out.println("Enter The problem Statement : ");
                            String statement=cin.nextLine();
                            System.out.println("Enter the Max Marks : ");
                            int marks=cin.nextInt();
                            m.add_assignment(i,statement,marks);
                        }
                        else
                        {
                            System.out.println("Enter the Quiz Question : ");
                            String ques=cin.nextLine();
                            m.add_quizzes(i,ques);
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
                while(true)
                {
                    System.out.println("Students : \n 0-S0 \n 1-S1 \n 2-S2");
                    int ID=cin.nextInt();
                    String stu="S2";
                    if(ID==0)
                    {
                        stu="S0";
                    }
                    if(ID==1)
                    {
                        stu="S1";
                    }

                    System.out.println("STUDENTS MENU \n 1.view lecture materials \n 2.view assessments \n 3.submit assessmenst" +
                            "\n 4. view grades \n 5. View comments \n 6.Add Comments \n 7. Logout");
                    int choice=cin.nextInt();
                    if(choice==1)
                    {
                        m.view_material();
                    }
                    if(choice == 2)
                    {
                        m.View_assessments();
                    }
                    if(choice == 3)
                    {
                        // submit assessments
                    }
                    if(choice == 4)
                    {
                        // view grades
                    }
                    if(choice == 5)
                    {
                        m.view_comments();
                    }
                    if(choice==6)
                    {
                        System.out.println("Enter The comments : ");
                        String s=cin.nextLine();
                        m.add_comments(s);
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

    void add_slides(instructor i,String topic,int slides,String uploader)
    {

        for(int j=1;j<=slides;j++)
        {
            System.out.println("Content in slide "+j);
            String content=cin.nextLine();
            i.setMater_slides(topic,content,uploader);
            inst.add(i);
        }

    }
    void add_video(instructor i,String topic,String content)
    {
        i.setMater_video(topic, content);
        inst.add(i);
    }
    void add_assignment( instructor i,String statement,int marks)
    {
        i.set_Assignment(statement,marks);
        inst.add(i);
    }
    void add_quizzes( instructor i,String statement)
    {
        i.set_quizzes(statement);
        inst.add(i);
    }
    void view_material()
    {
        for (int i = 0; i < inst.get(0).mater.size(); i++) {
            System.out.println(inst.get(0).mater.get(i));
        }
    }
    void View_assessments() {
        for (int i = 0; i < inst.get(0).assignment.size(); i++) {
            System.out.println(inst.get(0).assignment.get(i));
        }

        for (int i = 0; i < inst.get(0).quiz.size(); i++) {
            System.out.println(inst.get(0).quiz.get(i));
        }
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











}
