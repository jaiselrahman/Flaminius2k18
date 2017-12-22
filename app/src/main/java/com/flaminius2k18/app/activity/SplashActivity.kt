/**
 * Copyright [2017] [jaiselrahman]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flaminius2k18.app.activity

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.flaminius2k18.app.R

/**
 * Created by jaisel on 17/12/17.
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        open class Task : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                this@SplashActivity.startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                return null
            }

            override fun onPostExecute(result: Void?) {
                finish()
                super.onPostExecute(result)
            }
        }

        Handler().postDelayed({
            Task().execute()
        }, 2000)


    }
}