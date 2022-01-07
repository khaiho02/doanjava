package file;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface IFile {
    public void docFile(String link) throws FileNotFoundException;
    public void ghiFile(String link) throws FileNotFoundException, UnsupportedEncodingException;
}
