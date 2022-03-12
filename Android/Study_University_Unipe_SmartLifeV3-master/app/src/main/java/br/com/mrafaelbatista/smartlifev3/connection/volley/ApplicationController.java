package br.com.mrafaelbatista.smartlifev3.connection.volley;


import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.orm.SugarApp;

import br.com.mrafaelbatista.smartlifev3.connection.volley.image.BitmapLruCache;

//EXECUTA AO ABRIR O APP - COLOCAR NO ANDROIDMANIFEST
//EXTENDS DE APPLICATION ou Sugar
public class ApplicationController extends SugarApp {

	public static final String TAG = "VolleyPatterns";

	private RequestQueue mRequestQueue;

	private static final int MAX_IMAGE_CACHE_ENTRIES = 150;

	/**
	 * ImageLoader global
	 */
	private static ImageLoader mImageLoader;

	/**
	 * A singleton instance of the application class for easy access in other
	 * places
	 */
	private static ApplicationController sInstance;

	@Override
	public void onCreate() {
		super.onCreate();

		// initialize the singleton
		sInstance = this;

		// initialize image loader
		mImageLoader = new ImageLoader(getRequestQueue(), new BitmapLruCache(MAX_IMAGE_CACHE_ENTRIES));
	}

	/**
	 * @return ApplicationController singleton instance
	 */
	public static synchronized ApplicationController getInstance() {
		return sInstance;
	}

	/**
	 * @return The Volley Request queue, the queue will be created if it is null
	 */
	public RequestQueue getRequestQueue() {
		// lazy initialize the request queue, the queue instance will be
		// created when it is accessed for the first time
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

		VolleyLog.d("Adding request to queue: %s", req.getUrl());

		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}
	public static ImageLoader getImageLoader() {
		return mImageLoader;
	}

}