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







class instructor
{
    Scanner cin=new Scanner(System.in);
    String name;
    instructor(String name)
    {
        this.name=name;
    }
    void upolad_lm(ArrayList<materials> material)
    {

    }
    void upload_assignment(ArrayList<assessment> assessment)
    {

    }
    void close_assessments(ArrayList<assessment> assessment)
    {
        for (int i = 0; i < assessment.size(); i++) {
            System.out.println(i + " -> ");
            assessment.get(i).print_assessments();
        }
        System.out.println("choose the assessment to close : ");
        int code = cin.nextInt();

        for (int i = 0; i < assessment.size(); i++)
        {
            if (i == code)
            {
                assessment.get(i).setStatus("Close");
            }
        }
    }
    void view_lm(ArrayList<materials> material)
    {
        for(int i=0;i<material.size();i++)
        {
            material.get(i).view();
        }
    }
    void view_assessments(ArrayList<assessment> assessment)
    {
        for(int i=0;i<assessment.size();i++)
        {
            assessment.get(i).print_assessments();
        }

    }
    void grade_assessments(ArrayList<assessment> assessment)
    {
        for(int i=0;i<assessment.size();i++)
        {
            System.out.println(i+" -> ");
            assessment.get(i).print_assessments();
        }
        System.out.println("choose the assessment : ");
        int code=cin.nextInt();

        for(int i=0;i<assessment.size();i++)
        {
            if(i==code)
            {
                System.out.println("Maximum marks is : "+ assessment.get(i).getMax_marks());
                System.out.println("Enter The marks");
                int marks=cin.nextInt();

                assessment.get(i).submissions.is_graded=true;
                assessment.get(i).submissions.grade(marks,name);
            }
        }




    }
    void view_comments(ArrayList<COMMENTS> commments)
    {

    }
    void add_comments(ArrayList<COMMENTS> commments)
    {

    }


}










interface materials
{
    public void view();
}


class slides implements materials
{


    private String topic;
    private ArrayList<String> content;
    private Date date;
    private instructor uploader;



    slides(String topic,ArrayList<String> content,instructor upload)
    {
        this.topic=topic;
        this.content=content;
        this.uploader=upload;
        this.date=java.util.Calendar.getInstance().getTime();
    }


    int get_slides()
    {
        return content.size();
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

    public instructor getUploader() {
        return uploader;
    }

    @Override
    public void view()
    {
        System.out.println(this.topic);
        System.out.println(this.content);
        System.out.println(this.date);
        System.out.println(this.uploader.name);

    }
}







class video implements materials
{

    private String topic;
    private String content;
    private instructor uploader;
    private Date date;


    video(String topic,String content,instructor uploader)
    {
        this.topic=topic;
        this.uploader=uploader;
        this.content=content;
        this.date=java.util.Calendar.getInstance().getTime();
    }

    public instructor getUploader() {
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

    @Override
    public void view() {
        System.out.println(this.topic);
        System.out.println(this.content);
        System.out.println(this.date);
        System.out.println(this.uploader.name);

    }
}









class submission
{
    private student s;
    assessment assess;
    String I;
    int marks;
    String file_name;
    boolean is_graded=false;


    public int getMarks() {
        return marks;
    }

    public assessment getAssess() {
        return assess;
    }

    public String getI() {
        return I;
    }

    public student getS() {
        return s;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    void grade(int marks,String I)
    {
       this.marks=marks;
       this.I=I;
    }

    void view_grades()
    {
        System.out.println("graded");
        if(this.is_graded) {
            System.out.println("Submission is :" + this.file_name);
        }
        System.out.println("Ungraded");
        System.out.println("Submission is : "+ this.file_name);
    }
}





interface assessment
{
    void print_assessments();

    submission submissions=new submission();


    public int getMax_marks();
    public void setStatus(String status);
    public String getStatus();
    public boolean Is_submitted();
    public void setIs_submitted( boolean is_submitted);
}

class Assignment implements assessment
{

    private String Ques;

    private int max_marks;

    private String  status; // open or close

    private instructor I;

    boolean is_submitted=false;



    public Assignment(String statement, int marks,String status,instructor I) {
        this.max_marks=marks;
        this.Ques=statement;
        this.status="Open";
        this.I=I;

    }
    public boolean Is_submitted() {
        return is_submitted;
    }

    public instructor getI() {
        return I;
    }

    public String getStatus() {
        return status;
    }
    public void setIs_submitted(boolean is_submitted) {
        this.is_submitted = is_submitted;
    }

    public int getMax_marks() {
        return max_marks;
    }

    public String getQues() {
        return Ques;
    }

    public void setI(instructor i) {
        I = i;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMax_marks(int max_marks) {
        this.max_marks = max_marks;
    }

    public void setQues(String ques) {
        Ques = ques;
    }

    @Override
    public void print_assessments() {
        System.out.println("Question : " + getQues());
        System.out.println("Marks are : " + getMax_marks());
        System.out.println("Status : "+ getStatus());
        System.out.println("Uploaded by " + getI().name);
    }
}

















class Quiz implements  assessment
{


    private String Ques;

    private int max_marks;

    private String status; // open or close

    private instructor I;
    boolean is_submitted=false;


    Quiz(String ques,instructor I)
    {
        this.Ques=ques;
        this.status="Open";
        this.I=I;
        this.max_marks=1;
    }

    public boolean Is_submitted() {
        return is_submitted;
    }

    public void setIs_submitted(boolean is_submitted) {
        this.is_submitted = is_submitted;
    }

    public instructor getI() {
        return I;
    }

    public String getStatus() {
        return status;
    }

    public int getMax_marks() {
        return max_marks;
    }

    public String getQues() {
        return Ques;
    }

    public void setI(instructor i) {
        I = i;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMax_marks(int max_marks) {
        this.max_marks = max_marks;
    }

    public void setQues(String ques) {
        Ques = ques;
    }

    @Override
    public void print_assessments() {
        System.out.println("Question : " + getQues());
        System.out.println("Marks are : " + getMax_marks());
        System.out.println("Status : "+ getStatus());
        System.out.println("Uploaded by " + getI().name);
    }
}










class student
{
    ArrayList<assessment> ass = new ArrayList<>();
    Scanner cin=new Scanner(System.in);
      String student_name;
      student(String name)
      {
          this.student_name=name;
      }

    void view_lm(ArrayList<materials> material)
    {
        for(int i=0;i<material.size();i++)
        {
            material.get(i).view();
        }

    }
    void view_assessments(ArrayList<assessment> assessment)
    {
        for(int i=0;i<assessment.size();i++)
        {
            assessment.get(i).print_assessments();
        }

    }

    void submit_assessments()
    {
        System.out.println("Enter The ID to submit : ");
        int code=cin.nextInt();
        cin.nextLine();
        System.out.println("Enter the file name of assignment");
        String name=cin.nextLine();
        if(name.charAt(name.length()-1)=='p' && name.charAt(name.length()-2)=='i'
                && name.charAt(name.length()-3)=='z' && name.charAt(name.length()-4)=='.')
        {
            for(int i=0;i<ass.size();i++)
            {
                if(i==code)
                {
                    ass.get(i).submissions.setFile_name(name);
                    ass.get(i).setIs_submitted(true);
                }
            }

        }
        else
        {
            System.out.println("ERROR!!!!!! Wrong File name submitted");
        }


    }

    void view_grades()
    {
        for(int i=0;i<ass.size();i++)
        {
                ass.get(i).submissions.view_grades();
        }

    }

}



















public class Main {




    static ArrayList<materials> material=new ArrayList<>();

    static ArrayList<instructor> instructors=new ArrayList<>();

    static  ArrayList<student> students=new ArrayList<>();

    static ArrayList<assessment> assessments=new ArrayList<>();






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

            instructor I0=new instructor("I0");
            instructor I1=new instructor("I1");
            student s0=new student("s0");
            student s1=new student("s1");
            student s2=new student("s2");


            instructors.add(I0);
            instructors.add(I1);
            students.add(s0);students.add(s1);students.add(s2);


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
                            m.add_slides(topic,num,instructors.get(ID));

                            System.out.println("Welcome "+instructors.get(ID).name);
                        }
                        else
                        {

                            cin.nextLine();
                            System.out.println("Enter Topic of Slide : ");
                            String topic=cin.nextLine();
                            System.out.println("Enter The file name");
                            String file=cin.nextLine();
                            m.add_video(topic,file,instructors.get(ID));

                            System.out.println("Welcome "+instructors.get(ID).name);
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
                            m.add_assignment(statement,marks,instructors.get(ID));

                            System.out.println("Welcome "+instructors.get(ID).name);

                        }
                        else
                        {
                            cin.nextLine();

                            System.out.println("Enter the Quiz Question : ");
                            String ques=cin.nextLine();
                            m.add_quizzes(ques,instructors.get(ID));

                            System.out.println("Welcome "+instructors.get(ID).name);
                        }
                    }
                    if(choice==3)
                    {
                        m.view_material(instructors.get(ID));
                    }
                    if(choice == 4)
                    {
                        m.View_assessments(instructors.get(ID));
                    }
                    if(choice == 5)
                    {
                       m.get_grades(instructors.get(ID));
                    }
                    if(choice == 6)
                    {
                        m.close_assessment(instructors.get(ID));
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

                while(true)
                {
                    System.out.println("STUDENTS MENU \n 1.view lecture materials \n 2.view assessments \n 3.submit assessments" +
                            "\n 4. view grades \n 5. View comments \n 6.Add Comments \n 7. Logout");
                    int choice=cin.nextInt();
                    if(choice==1)
                    {
                        m.student_view_material(students.get(ID));
                    }
                    if(choice == 2)
                    {
                        m.student_View_assessments(students.get(ID));
                    }
                    if(choice == 3)
                    {
                        m.submit_assignment(students.get(ID));

                    }
                    if(choice == 4)
                    {
                        m.view_grades(students.get(ID));
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








    void add_slides(String topic,int slides,instructor uploader)
    {

        ArrayList<String> materials=new ArrayList<String>();

        for(int j=1;j<=slides;j++) {

            System.out.println("Content in slide" + " " + j);

            String content = cin.nextLine();

            materials.add(content);
        }

            slides s=new slides(topic,materials,uploader);
        material.add(s);

    }





    void add_video(String topic,String content,instructor uploader)
    {

        video v=new video(topic, content,uploader);
        material.add(v);
    }






    void add_assignment(String statement,int marks,instructor i)
    {
        Assignment assi=new Assignment(statement,marks,"Open",i);
        assessments.add(assi);
    }





    void add_quizzes(String statement, instructor i)
    {
        Quiz q=new Quiz(statement,i);
        assessments.add(q);
    }






    void view_material(instructor I)
    {
        I.view_lm(material);
    }

    void View_assessments(instructor I)
    {
       I.view_assessments(assessments);
    }


    void get_grades(instructor I)
    {
            I.grade_assessments(assessments);
    }

    void close_assessment(instructor I)
    {
        I.close_assessments(assessments);
    }



    void student_view_material(student s)
    {
        s.view_lm(material);

    }


    void student_View_assessments(student s)
    {
        s.view_assessments(assessments);
    }

    void submit_assignment(student s)
    {
        for(int i=0;i<assessments.size();i++)
        {
            if(assessments.get(i).getStatus().equals("Open") && assessments.get(i).Is_submitted()==false)
            {
                System.out.println(i+" ");
                assessments.get(i).print_assessments();
            }
        }
        s.submit_assessments();
    }

    void view_grades(student s)
    {
        s.view_grades();
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
