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
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.flaminius2k18.app.R

/**
 * Created by jaisel on 16/12/17.
 */
class ContactUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
    }

    fun onClickCall(v: View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("tel:7448601782"))
        startActivity(intent)
    }

    fun onClickMail(v: View) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.setData(Uri.parse("mailto:jaiselrahman@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Flaminus2k18")
        startActivity(intent)
    }

    fun onClickLocation(v: View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("geo:13.0418790,80.1890010"))
        startActivity(intent)
    }
}