package com.example.madlevel3task2

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_portals.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalsFragment : Fragment() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals) { portal: Portal -> itemClicked(portal) }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeAddPortalResult()
    }

    private fun initViews() {
        rvPortals.layoutManager =
            GridLayoutManager(context, 2)
        rvPortals.adapter = portalAdapter
        portalAdapter.notifyDataSetChanged()
    }

    private fun observeAddPortalResult() {
        setFragmentResultListener(REQ_PORTAL_KEY) { key, bundle ->
            val portalName = bundle.getString(BUNDLE_PORTAL_NAME)
            val portalUrl = bundle.getString(BUNDLE_PORTAL_URL)
            if (!portalName.isNullOrBlank() && !portalUrl.isNullOrBlank()) {
                val portal = Portal(portalName, portalUrl)
                portals.add(portal)
                portalAdapter.notifyDataSetChanged()
            } else {
                Log.e("PortalsFragment", "Request triggered, but empty portal name or url!")
            }

        }
    }

    private fun itemClicked(portalItem: Portal) {
        val builder = CustomTabsIntent.Builder().build()
        context?.let { builder.launchUrl(it, Uri.parse(Uri.decode(portalItem.portalLink))) }
    }
}