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

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.flaminius2k18.app.R
import com.flaminius2k18.app.adapter.EventListAdapter
import com.flaminius2k18.app.model.EventItem
import kotlinx.android.synthetic.main.activity_event_info.*
import java.util.*

/**
 * Created by jaisel on 20/12/17.
 */
class EventInfoActivity : AppCompatActivity() {
    var eventItems = Vector<EventItem>()
    var eventAdapter = EventListAdapter(this, eventItems)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)
        eventItems.add(EventItem().apply {
            title = "title 1"
            description = "A material metaphor is the unifying theory of a rationalized space and a system of motion." +
                    "The material is grounded in tactile reality, inspired by the study of paper and ink, yet " +
                    "technologically advanced and open to imagination and magic.\n"
            fee = "50 Rs"
            prize = "100 Rs"
        })

        eventItems.add(EventItem().apply {
            title = "Dig the bug"
            description = "This is some event"
            fee = "50 Rs"
            prize = "None"
        })
        eventItems.add(EventItem().apply {
            title = "Compile"
            description = "\"A material metaphor is the unifying theory of a rationalized space and a system of motion.\"\n" +
                    "        \"The material is grounded in tactile reality, inspired by the study of paper and ink, yet \"\n" +
                    "        \"technologically advanced and open to imagination and magic.\\n\"\n" +
                    "        \"Surfaces and edges of the material provide visual cues that are grounded in reality. The \"\n" +
                    "        \"use of familiar tactile attributes helps users quickly understand affordances. Yet the \"\n" +
                    "        \"flexibility of the material creates new affordances that supercede those in the physical \"\n" +
                    "        \"world, without breaking the rules of physics.\\n\"\n" +
                    "        \"The fundamentals of light, surface, and movement are key to conveying how objects move, \"\n" +
                    "        \"interact, and exist in space and in relation to each other. Realistic lighting shows \"\n" +
                    "        \"seams, divides space, and indicates moving parts.\\n\\n\""
            fee = "50 Rs"
            prize = "None"
        })

        val lm = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
        lm.setPostLayoutListener(CarouselZoomPostLayoutListener())
        event_list.layoutManager = lm
        event_list.setHasFixedSize(false)
        event_list.adapter = eventAdapter
    }

    companion object {
        class adapter(val context: Context) : RecyclerView.Adapter<adapter.VH>() {
            override fun onBindViewHolder(holder: VH, position: Int) {
                holder.img.setBackgroundResource(MainActivity.pics[position])
            }

            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
                return VH(ImageView(context))
            }

            override fun getItemCount(): Int {
                return 14
            }

            class VH(v: View) : RecyclerView.ViewHolder(v) {
                val img = v
            }
        }
    }
}