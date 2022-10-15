package com.example.surf_with_presenter.presentation

import android.util.Log
import com.example.surf_with_presenter.domain.usecase.MainUseCases
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val mainUseCases: MainUseCases,
) : MvpPresenter<AddToRecyclerPictureInfoView>() {
    var list = listOf<ViewPictureInfo>()

    private fun getSingleOnRecyclerView(): SingleObserver<List<ViewPictureInfo>> {
        return object : SingleObserver<List<ViewPictureInfo>> {
            override fun onSubscribe(d: Disposable) {
                Log.v("subscribe", "sub")
            }

            override fun onError(e: Throwable) {
//                viewState.setErrorMessage(e.message ?: "")
            }

            override fun onSuccess(persons: List<ViewPictureInfo>) {
                list = list + persons
                viewState.setPictureInfoOnRecyclerView(list)
            }
        }
    }

    private fun getSingleToken(): SingleObserver<List<ViewPictureInfo>> {
        return object : SingleObserver<String> {
            override fun onSubscribe(d: Disposable) {
                Log.v("subscribe", "sub")
            }

            override fun onError(e: Throwable) {
//                viewState.setErrorMessage(e.message ?: "")
            }

            override fun onSuccess(persons: List<ViewPictureInfo>) {
                list = list + persons
                viewState.setPictureInfoOnRecyclerView(list)
            }
        }
    }


    fun getProfileInfo(token: String) {
        mainUseCases.getPictureInfo(token)
            .map { listPictureInfo -> listPictureInfo.map { pictureInfo -> pictureInfo.toViewPictureInfo() } }
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.newThread())
            .subscribe(getSingleOnRecyclerView())
    }
}