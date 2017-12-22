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

package com.flaminius2k18.app.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.flaminius2k18.app.R
import com.flaminius2k18.app.model.EventItem
import kotlinx.android.synthetic.main.event_list_item.view.*
import java.util.*

/**
 * Created by jaisel on 15/12/17.
 */
class EventListAdapter(private var context: Context, private var eventItems: Vector<EventItem>) : RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.event_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.title?.text = eventItems[position].title
        holder?.description?.text = eventItems[position].description
        holder?.fee?.text = eventItems[position].fee
        holder?.prize?.text = eventItems[position].prize
    }

    override fun getItemCount(): Int {
        return eventItems.size
    }

    class ViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.title
        var description = view.description
        var fee: TextView? = view.fee
        var prize: TextView? = view.prize
    }
}