package utils;

import pages.common.HomePage;
import pages.dashboard.AddProject;
import pages.dashboard.AddTask;
import pages.dashboard.ViewTasks;
import pages.login.Login;
import pages.settings.UserSettings;
import pages.signUp.SignUp;
import pages.taskdb.SearchTask;
import pages.taskdb.SortTasks;
import pages.taskdb.ViewAllTasks;

public class Page extends BaseTest {

    private HomePage homePage;
    private Login login;
    private SignUp signUp;
    private AddProject addProject;
    private AddTask addTask;
    private ViewTasks viewTasks;
    private ViewAllTasks viewAllTasks;
    private SearchTask searchTask;
    private SortTasks sortTasks;
    private UserSettings userSettings;

    public Page log(String logText) {
        super.log(logText);
        return this;
    }

    public HomePage homePage() {
        synchronized (this) {
            if (homePage == null) {
                homePage = new HomePage();
            }
        }
        return homePage;
    }

    public Login login() {
        synchronized (this) {
            if (login == null) {
                login = new Login();
            }
        }
        return login;
    }

    public SignUp signUp() {
        synchronized (this) {
            if (signUp == null) {
                signUp = new SignUp();
            }
        }
        return signUp;
    }

    public AddProject addProject() {
        synchronized (this) {
            if (addProject == null) {
                addProject = new AddProject();
            }
        }
        return addProject;
    }


    public AddTask addTask() {
        synchronized (this) {
            if (addTask == null) {
                addTask = new AddTask();
            }
        }
        return addTask;
    }

    public ViewTasks viewTasks() {
        synchronized (this) {
            if (viewTasks == null) {
                viewTasks = new ViewTasks();
            }
        }
        return viewTasks;
    }

    public ViewAllTasks viewAllTasks() {
        synchronized (this) {
            if (viewAllTasks == null) {
                viewAllTasks = new ViewAllTasks();
            }
        }
        return viewAllTasks;
    }

    public SearchTask searchTask() {
        synchronized (this) {
            if (searchTask == null) {
                searchTask = new SearchTask();
            }
        }
        return searchTask;
    }

    public SortTasks sortTasks() {
        synchronized (this) {
            if (sortTasks == null) {
                sortTasks = new SortTasks();
            }
        }
        return sortTasks;
    }

    public UserSettings userSettings() {
        synchronized (this) {
            if (userSettings == null) {
                userSettings = new UserSettings();
            }
        }
        return userSettings;
    }
}
