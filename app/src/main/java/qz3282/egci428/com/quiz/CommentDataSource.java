/*package qz3282.egci428.com.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;


public class CommentDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID,MySQLiteHelper.COLUMN_COMMENT};
    public CommentDataSource(Context context){ dbHelper = new MySQLiteHelper(context);
    }
    public void open()throws SQLException { database = dbHelper.getWritableDatabase();
    }
    public void close(){ dbHelper.close();
    }
    public Comment createComment(String comment){
        ContentValues values = new ContentValues(); values.put(MySQLiteHelper.COLUMN_COMMENT,comment);
        long insertID = database.insert(MySQLiteHelper.TABLE_COMMENTS,null,values); Cursor cursor =
                database.query(MySQLiteHelper.TABLE_COMMENTS,allColumns,MySQLiteHelper.COLUMN_ID+" = "+insertID,null,null,null,null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor); cursor.close();
        return newComment; }
    public void deleteComent(Comment comment){
        long id = comment.getId();
        System.out.println("Comment Delete with ID: "+id); database.delete(MySQLiteHelper.TABLE_COMMENTS,MySQLiteHelper.COLUMN_ID+" = "+id,null);
    }
    public List<Comment> getAllComment(){
        List<Comment> comments = new ArrayList<Comment>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,allColumns,null,null,null,null,null); cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Comment comment = cursorToComment(cursor); comments.add(comment);
            cursor.moveToNext();
        }
        cursor.close(); return comments;
    }
    public Comment cursorToComment(Cursor cursor){ Comment comment = new Comment(); comment.setId(cursor.getLong(0)); comment.setComment(cursor.getString(1)); return comment;
    }
}
*/