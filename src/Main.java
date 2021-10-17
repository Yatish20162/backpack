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
                int ID=cin.nextInt();
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

                    }
                }




            }




            if (login == 2) {

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
    void view_student_material(student s)
    {

        for(int i=0;i<inst.get(0).mater.size();i++)
        {
            System.out.println(inst.get(0).mater.get(i));
        }

        for(int i=0;i<inst.get(0).assignment.size();i++)
        {
            System.out.println(inst.get(0).assignment.get(i));
        }

        for(int i=0;i<inst.get(0).quiz.size();i++)
        {
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
