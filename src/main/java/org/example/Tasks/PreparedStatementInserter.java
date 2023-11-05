package org.example.Tasks;

import org.example.entities.Client;
import org.example.entities.Project;
import org.example.entities.ProjectWorker;
import org.example.entities.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInserter {
    private static final String WORKERS_INSERT = "INSERT INTO workers (\"name\", birthday, \"level\", salary) VALUES (?, ?, ?, ?)";
    private static final String CLIENTS_INSERT = "INSERT INTO clients (\"name\") VALUES (?)";
    private static final String PROJECTS_INSERT = "INSERT INTO projects (client_id, start_date, finish_date) VALUES (?, ?, ?)";
    private static final String PROJECT_WORKERS_INSERT = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";

    private Connection connection;

    public PreparedStatementInserter(Connection connection) {
        this.connection = connection;
    }

    public int insertWorker(Worker worker) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(WORKERS_INSERT)){
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setDate(2, worker.getBirthday());
            preparedStatement.setString(3, worker.getLevel());
            preparedStatement.setInt(4, worker.getSalary());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int insertClient(Client client){
        try(PreparedStatement preparedStatement = connection.prepareStatement(CLIENTS_INSERT)){
            preparedStatement.setString(1, client.getName());
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int insertProject(Project project){
        try(PreparedStatement preparedStatement = connection.prepareStatement(PROJECTS_INSERT)){
            preparedStatement.setInt(1, project.getClientId());
            preparedStatement.setDate(2, project.getStartDate());
            preparedStatement.setDate(3, project.getFinishDate());
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int insertProjectWorker(ProjectWorker projectWorker){
        try(PreparedStatement preparedStatement = connection.prepareStatement(PROJECT_WORKERS_INSERT)){
            preparedStatement.setInt(1, projectWorker.getProjectId());
            preparedStatement.setInt(2, projectWorker.getWorkerId());
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
