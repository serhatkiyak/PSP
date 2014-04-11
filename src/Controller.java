/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serhat
 */
public class Controller 
{
    static String username;
    static Login login;
    static Index index;
    static Signup signup;
    static UserFound userFound;
    static Project project;
    static FileDownloadDialog fileDownloadDialog;
    static MyProjects myProjects;
    static AddExecutor addExecutor;
    static AddProject addProject;
    
    public static void loginToIndex(String myusername)
    {
        username = myusername;
        login.setVisible(false);
        login.dispose();
        index = new Index();
        index.passUsername(username);
        index.setVisible(true);
    }
    
    public static void loginToSignup()
    {
        login.setVisible(false);
        login.dispose();     
        signup = new Signup();
        signup.setVisible(true);
    }
    
    public static void signupToLogin()
    {
        signup.setVisible(false);
        signup.dispose();     
        login = new Login();
        login.setVisible(true);
    }    
    
    public static void indexToUserFound(String username, String searchUsername)
    {
        index.setVisible(false);
        index.dispose();     
        userFound = new UserFound();
        userFound.passUsernames(username, searchUsername);
        userFound.setVisible(true);
    }        
    
    public static void userFoundToProject(String username, String searchUsername, String projectName)
    {
        userFound.setVisible(false);
        userFound.dispose();     
        project = new Project();
        project.passUsernamesAndProjectName(username, searchUsername, projectName);
        project.setVisible(true);
    }  
    
    public static void projectToFileDownloadDialog(String username, String searchUsername, String projectName, String fileName)
    {    
        project.setVisible(false);
        fileDownloadDialog = new FileDownloadDialog();
        fileDownloadDialog.passUsernamesProjectAndFileName(username, searchUsername, projectName, fileName);
        fileDownloadDialog.setVisible(true);
    }        
    
    public static void fileDownloadDialogToProject()
    {    
        fileDownloadDialog.setVisible(false);
        project.setVisible(true);
    }      

    public static void indexToMyProjects(String username)
    {
        index.setVisible(false);
        index.dispose();     
        myProjects = new MyProjects();
        myProjects.passUsername(username);
        myProjects.setVisible(true);
    }  
    
    public static void myProjectsToAddExecutor(String username, String selectedProject)
    {     
        if(addExecutor == null)
        {
            addExecutor = new AddExecutor();
            addExecutor.passUsernameAndProject(username, selectedProject);
            addExecutor.setVisible(true);
        }
    }
    
    public static void refreshExecutorList()
    {
        myProjects.refreshExecutorList();
    }
    
    public static void myProjectsToAddProject(String username)
    {     
        if(addProject == null)
        {
            addProject = new AddProject();
            addProject.passUsername(username);
            addProject.setVisible(true);
        }
    }
    
    public static void refreshProjectList()
    {
        myProjects.refreshProjectList();
    }        
    
    public static void main(String[] args)
    {
        login = new Login();
        login.setVisible(true);
    }
    
}
