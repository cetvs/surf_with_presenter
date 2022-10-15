package com.example.surf_with_presenter.data.repository

import com.example.surf_with_presenter.data.source.local.AppDao
import com.example.surf_with_presenter.data.models.toDomainPictureInfo
import com.example.surf_with_presenter.data.source.remote.SimpleApi
import com.example.surf_with_presenter.domain.models.DomainPictureInfo
import com.example.surf_with_presenter.domain.repository.MainRepository
import io.reactivex.Single

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi,
) : MainRepository {

    override fun getPictureInfo(token: String): Single<List<DomainPictureInfo>> =
        simpleApi.getPictureInfo("Token $token")
            .map { list -> list.map { remotePictureInfo -> remotePictureInfo.toDomainPictureInfo() } }


//    override suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo? {
//        return simpleApi.getProfileInfo(profileRequestBody)
//    }
//
//    override suspend fun getPictureInfo(token: String): List<PictureInfo> =
//        simpleApi.getPictureInfo("Token $token")
//
//    override suspend fun postAuthLogout(token: String) {
//        simpleApi.postAuthLogout("Token $token")
//    }
//
//    override fun getLocalPictureInfo(): Flow<List<EntityPictureInfo>> =
//        appDao.getPictureInfo()
//
//    override fun getLocalProfileInfo(): ProfileInfo? =
//        appDao.getProfileInfo()
//
//    override fun insertProfileInfo(profileInfo: ProfileInfo) {
//        appDao.insertProfileInfo(profileInfo)
//    }
//
//    override fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>) {
////        appDao.insertPicturesInfo(picturesInfo)
//    }
//
//    override fun checkEntityPictureInfo(id: Int) : Date? {
//        return appDao.checkFavoriteDate(id)
//    }
//
//    override fun updateEntityPictureInfo(picturesInfo: EntityPictureInfo) {
//        appDao.updatePictureInfo(picturesInfo)
//    }
//
//    override fun insertPictureInfo(picturesInfo: EntityPictureInfo) {
//        appDao.insertPicturesInfo(picturesInfo)
//    }
//
//    override fun deleteProfileInfo(){
//        appDao.deleteProfileInfo()
//    }
//
//    override fun deleteAllMenuItems() {
//        appDao.deleteAllMenuItems()
//    }
}