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
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.ViewSwitcher
import com.flaminius2k18.app.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var timer = Timer()

    companion object {
        val pics = intArrayOf(
                R.drawable.dsc_1,
                R.drawable.dsc_2,
                R.drawable.dsc_3,
                R.drawable.dsc_4,
                R.drawable.dsc_5,
                R.drawable.dsc_6,
                R.drawable.dsc_7,
                R.drawable.dsc_8,
                R.drawable.dsc_9,
                R.drawable.dsc_10,
                R.drawable.dsc_11,
                R.drawable.dsc_12,
                R.drawable.dsc_13,
                R.drawable.dsc_14
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        slider.setFactory(ViewSwitcher.ViewFactory {
            ImageView(this)
        })
        slider.setInAnimation(this, R.anim.slide_in)
        slider.setOutAnimation(this, R.anim.slide_out)
        var position = 0
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    slider.setImageResource(pics[position])
                    position++
                    if (position == pics.size) {
                        position = 0
                    }
                }
            }
        }, 0, 3000)

        about_flaminus.setOnClickListener { _ ->
            startActivity(Intent(this, FlaminiusActivity::class.java))
        }

        about_college.setOnClickListener { _ ->
            startActivity(Intent(this, CollegeActivity::class.java))
        }

        register.setOnClickListener { _ ->
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        event_info.setOnClickListener { _ ->
            startActivity(Intent(this, EventInfoActivity::class.java))
        }

        event_gallery.setOnClickListener { _ ->
            startActivity(Intent(this, GalleryActivity::class.java))
        }

        contact_us.setOnClickListener { _ ->
            startActivity(Intent(this, ContactUsActivity::class.java))
        }

        fab.setOnClickListener { _ ->
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Flaminus2k18")
            intent.putExtra(Intent.EXTRA_TEXT, "Flaminus2k18 - A National Level Symposim\nhttp://flaminus2k18.com")
            startActivity(Intent.createChooser(intent, "Share"))
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        main_content?.scheduleLayoutAnimation()
    }
}
