package com.marlena.pictures_context_project.scenes.picture

import com.marlena.pictures_context_project.model.domain.ThePicture
import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.persistence.MyPicturesDB

class PicturePresenter(private val view: Picture.View) : Picture.Presenter {

    override fun insertMyPicture(thePicture: ThePicture) {
        var myPicture: MyPictureEntity?
        val url = thePicture.url

        if (url.isNotEmpty()) {
            myPicture = getMyPictureByUrl(url)
            val sensation = view.getEdt()

            when {
                myPicture == null -> {
                    myPicture = convertDomainInToMyPictures(thePicture)
                    myPicture.sensation = sensation
                    MyPicturesDB.instance.mypicturesDAO().insert(myPicture)
                    view.showMessage("Imagem adicionada com SUCESSO!")
                    view.onBackPressed()
                }
                sensation != myPicture.sensation -> {
                    val myPictureTemp = myPicture
                    MyPicturesDB.instance.mypicturesDAO().delete(myPicture)
                    myPictureTemp.sensation = sensation
                    MyPicturesDB.instance.mypicturesDAO().insert(myPictureTemp)
                    view.showMessage("Sensations foi editada com SUCESSO.")
                }
                else -> view.showMessage("Atenção! Imagem já Existe")
            }
        }
    }

    override fun getMyPictureByUrl(url: String): MyPictureEntity? {
        return MyPicturesDB.instance.mypicturesDAO().getByUrl(url)
    }

    private fun convertDomainInToMyPictures(thePicture: ThePicture ): MyPictureEntity{
        val myPicture = MyPictureEntity()

        myPicture.url = thePicture.url
        myPicture.name = thePicture.name
        return myPicture
    }
}