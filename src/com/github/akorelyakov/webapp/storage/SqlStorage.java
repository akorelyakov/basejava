package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.exception.NotExistStorageException;
import com.github.akorelyakov.webapp.model.Resume;
import com.github.akorelyakov.webapp.sql.ConnectionFactory;
import com.github.akorelyakov.webapp.sql.SqlHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {
    public final SqlHelper sqlHelper;
    public final ConnectionFactory connectionFactory;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
        connectionFactory = ()-> DriverManager.getConnection(dbUrl, dbUser, dbPassword);    }

    @Override
    public void clear() {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps = conn.prepareStatement("DELETE FROM resume")) {
//            ps.execute();
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
        sqlHelper.makeExecution("DELETE FROM resume", PreparedStatement::execute);
    }

    @Override
    public void update(Resume resume) {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps =
//                     conn.prepareStatement("UPDATE resume SET full_name = ? WHERE uuid = ?")) {
//            ps.setString(1, resume.getFullName());
//            ps.setString(2, resume.getUuid());
//            if (ps.executeUpdate() == 0) {
//                throw new NotExistStorageException(resume.getUuid());
//            }
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
        sqlHelper.makeExecution("UPDATE resume SET full_name = ? WHERE uuid = ?", ps -> {
            ps.setString(1, resume.getFullName());
            ps.setString(2, resume.getUuid());
            if (ps.executeUpdate() == 0) {
                throw new NotExistStorageException(resume.getUuid());
            }
            return null;
        });
    }

    @Override
    public void save(Resume resume) {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps =
//                     conn.prepareStatement("INSERT INTO resume (uuid, full_name) VALUES (?, ?)")) {
//            ps.setString(1, resume.getUuid());
//            ps.setString(2, resume.getFullName());
//            ps.execute();
//        } catch (SQLException e) {
//            if (e.getSQLState().equals(POSTEGRESQL_DUPLICATE_PK)) {
//                throw new ExistStorageException(resume.getUuid());
//            }
//        }
        sqlHelper.makeExecution("INSERT INTO resume (uuid, full_name) VALUES (?, ?)", ps -> {
            ps.setString(1, resume.getUuid());
            ps.setString(2, resume.getFullName());
            ps.execute();
            return null;
        });
    }

    @Override
    public Resume get(String uuid) {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps = conn.prepareStatement("SELECT * from resume r WHERE r.uuid =?")) {
//            ps.setString(1, uuid);
//            ResultSet rs = ps.executeQuery();
//            if (!rs.next()) {
//                throw new NotExistStorageException(uuid);
//            }
//            return new Resume(uuid, rs.getString("full_name"));
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
        return sqlHelper.makeExecution("SELECT * from resume r WHERE r.uuid =?", ps -> {
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        });
    }

    @Override
    public void delete(String uuid) {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps = conn.prepareStatement("DELETE FROM resume WHERE uuid =?")) {
//            ps.setString(1, uuid);
//            if (ps.executeUpdate() == 0) {
//                throw new NotExistStorageException(uuid);
//            }
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
        sqlHelper.makeExecution("DELETE FROM resume WHERE uuid =?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new NotExistStorageException(uuid);
            }
            return null;
        });
    }

    @Override
    public List<Resume> getAllSorted() {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume ORDER BY full_name, uuid")) {
//            ResultSet rs = ps.executeQuery();
//            ArrayList<Resume> list = new ArrayList<>();
//            while (rs.next()) {
//                list.add(new Resume(rs.getString("uuid"), rs.getString("full_name")));
//            }
//            return list;
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
        return sqlHelper.makeExecution("SELECT * FROM resume ORDER BY full_name, uuid", ps -> {
            ResultSet rs = ps.executeQuery();
            ArrayList<Resume> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Resume(rs.getString("uuid"), rs.getString("full_name")));
            }
            return list;
        });
    }

    @Override
    public int size() {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM resume")) {
//            int size = 0;
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                size = rs.getInt(1);
//            }
//            return size;
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
        return sqlHelper.makeExecution("SELECT COUNT(*) FROM resume", ps -> {
            int size = 0;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                size = rs.getInt(1);
            }
            return size;
        });
    }
}
