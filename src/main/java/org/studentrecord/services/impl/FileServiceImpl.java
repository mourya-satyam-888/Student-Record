package org.studentrecord.services.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.studentrecord.constants.PathConstants;
import org.studentrecord.exceptions.FileException;
import org.studentrecord.models.Student;
import org.studentrecord.models.StudentCollection;
import org.studentrecord.services.FileService;

/**
 * The type Data base service.
 */
public class FileServiceImpl implements FileService {
  @Override
  public void readFile() {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new BufferedInputStream(Files.newInputStream(
            Paths.get(PathConstants.FILE_PATH))))) {
      StudentCollection.getInstance().clearList();
      while (true) {
        StudentCollection.getInstance()
            .addStudent((Student) inputStream.readObject());
      }
    } catch (EOFException ex) {
      return;
    } catch (Exception e) {
      throw new FileException("File not Found");
    }
  }

  @Override
  public void writeFile() {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new BufferedOutputStream(Files.newOutputStream(
            Paths.get(PathConstants.FILE_PATH))))) {
      final StudentCollection studentCollection = StudentCollection.getInstance();
      for (final Student student : studentCollection.getStudents()) {
        outputStream.writeObject(student);
      }
    } catch (Exception e) {
      throw new FileException("File Not Found");
    }
  }
}
