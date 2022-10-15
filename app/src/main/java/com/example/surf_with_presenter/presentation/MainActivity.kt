package com.example.surf_with_presenter.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surf_with_presenter.R
import com.example.surf_with_presenter.SurfApp
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity(), AddToRecyclerPictureInfoView {
    private var recyclerView: RecyclerView? = null
    private var homeRecyclerAdapter: HomeRecyclerAdapter? = null

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return presenterProvider.get()
    }

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as SurfApp).appComponent.inject(this)

        recyclerView = findViewById(R.id.home_rv)
        homeRecyclerAdapter = HomeRecyclerAdapter(listOf())
        recyclerView?.adapter = homeRecyclerAdapter
        recyclerView?.layoutManager = GridLayoutManager(this, 2)
    }

    override fun setPictureInfoOnRecyclerView(list: List<ViewPictureInfo>) {
        homeRecyclerAdapter?.setData(list)
    }
}