package org.example.Tasks;

import org.example.config.H2Db;
import org.example.entities.Client;
import org.example.entities.Project;
import org.example.entities.ProjectWorker;
import org.example.entities.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection connection = H2Db.getConnection();
        PreparedStatementInserter psi = new PreparedStatementInserter(connection);

        List<Worker> workerList = Arrays.asList(
                new Worker("Max",  Date.valueOf("2000-01-01"), "Junior", 1500),
                new Worker("Oleh", Date.valueOf("1999-02-12"), "Middle", 3200),
                new Worker("John", Date.valueOf("1984-07-23"), "Senior", 6000),
                new Worker("Max", Date.valueOf("2004-02-05"), "Trainee", 600),
                new Worker("Due", Date.valueOf("2005-08-26"), "Junior", 1200),
                new Worker("Ann", Date.valueOf("1976-06-27"), "Senior", 7800),
                new Worker("Bill", Date.valueOf("2000-12-31"), "Middle", 4000),
                new Worker("Anthony", Date.valueOf("1994-02-03"), "Senior", 5300),
                new Worker("Dmytro", Date.valueOf("2001-09-09"), "Middle", 3600),
                new Worker("Sam", Date.valueOf("1998-05-23"), "Senior", 7000)
        );
        for (Worker worker : workerList){
            psi.insertWorker(worker);
        }

        List<Client> clientList = Arrays.asList(
                new Client("Ashot"),
                new Client("Miron"),
                new Client("Alex"),
                new Client("Jason"),
                new Client("Robert")
        );
        for(Client client : clientList){
            psi.insertClient(client);
        }


        List<Project> projectList = Arrays.asList(
                new Project(1, Date.valueOf("2023-08-20"), Date.valueOf("2024-08-21")),
                new Project(3, Date.valueOf("2022-05-13"), Date.valueOf("2023-01-17")),
                new Project(2, Date.valueOf("2023-03-24"), Date.valueOf("2024-05-25")),
                new Project(1, Date.valueOf("2023-03-06"), Date.valueOf("2023-12-10")),
                new Project(5, Date.valueOf("2021-06-21"), Date.valueOf("2023-12-22")),
                new Project(4, Date.valueOf("2023-11-28"), Date.valueOf("2025-04-28")),
                new Project(3, Date.valueOf("2022-09-05"), Date.valueOf("2024-09-05")),
                new Project(3, Date.valueOf("2023-04-30"), Date.valueOf("2024-06-30")),
                new Project(5, Date.valueOf("2021-03-01"), Date.valueOf("2026-07-22")),
                new Project(1, Date.valueOf("2023-05-11"), Date.valueOf("2025-06-23"))
        );
        for(Project project : projectList){
            psi.insertProject(project);
        }

        List<ProjectWorker> projectWorkerList = Arrays.asList(
                new ProjectWorker(1, 3  ),
                new ProjectWorker(1, 4  ),
                new ProjectWorker(1, 1  ),
                new ProjectWorker(1, 5  ),
                new ProjectWorker(2, 6  ),
                new ProjectWorker(2, 7  ),
                new ProjectWorker(2, 8  ),
                new ProjectWorker(3, 9  ),
                new ProjectWorker(3, 10 ),
                new ProjectWorker(3, 7  ),
                new ProjectWorker(4, 2  ),
                new ProjectWorker(5, 2  ),
                new ProjectWorker(5, 1  ),
                new ProjectWorker(6, 6  ),
                new ProjectWorker(6, 7  ),
                new ProjectWorker(7, 4  ),
                new ProjectWorker(7, 5  ),
                new ProjectWorker(7, 6  ),
                new ProjectWorker(7, 7  ),
                new ProjectWorker(7, 8  ),
                new ProjectWorker(8, 3  ),
                new ProjectWorker(8, 4  ),
                new ProjectWorker(9, 5  ),
                new ProjectWorker(9, 1  ),
                new ProjectWorker(10, 2 ),
                new ProjectWorker(10, 10)
        );
        for (ProjectWorker projectWorker : projectWorkerList){
            psi.insertProjectWorker(projectWorker);
        }
    }
}
