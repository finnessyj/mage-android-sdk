package mil.nga.giat.mage.sdk.fetch;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import mil.nga.giat.mage.sdk.R;
import mil.nga.giat.mage.sdk.datastore.user.User;
import mil.nga.giat.mage.sdk.datastore.user.UserHelper;
import mil.nga.giat.mage.sdk.preferences.PreferenceHelper;
import mil.nga.giat.mage.sdk.utils.MediaUtility;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class UserAvatarFetchTask extends AsyncTask<User, Void, Void> {
	private static final String LOG_NAME = UserAvatarFetchTask.class.getName();
	
    Context context;

    public UserAvatarFetchTask(Context context) {
        this.context = context;
    }

    protected Void doInBackground(User... users) {
    	String token = PreferenceHelper.getInstance(context).getValue(R.string.tokenKey);
    	for (User user : users) {
    		Log.d(LOG_NAME, "Fetching avatar at url: " + user.getAvatarUrl());
	        String urldisplay = user.getAvatarUrl() + "?access_token=" + token;
	        
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            Bitmap avatar = BitmapFactory.decodeStream(in);
	            
	    		FileOutputStream out = null;
	    		try {
	    			String localPath = MediaUtility.getAvatarDirectory() + "/" + user.getId();
	    		    out = new FileOutputStream(localPath);
	    		    avatar.compress(Bitmap.CompressFormat.PNG, 90, out);
	    		    user.setLocalAvatarPath(localPath);
	    		    UserHelper.getInstance(context).update(user);
	    		} catch (Exception e) {
	    		    e.printStackTrace();
	    		} finally {
	    		    try {
	    		        if (out != null) {
	    		            out.close();
	    		        }
	    		    } catch (IOException e) {
	    		        e.printStackTrace();
	    		    }
	    		}
	        } catch (Exception e) {
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
	        }
    	}
    	return null;
    }
}