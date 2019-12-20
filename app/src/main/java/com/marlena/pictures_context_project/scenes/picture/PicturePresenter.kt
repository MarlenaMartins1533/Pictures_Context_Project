package com.marlena.pictures_context_project.scenes.picture

import com.marlena.pictures_context_project.model.domain.ThePicture
import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.persistence.MyPicturesDB

class PicturePresenter(private val view: Picture.View) : Picture.Presenter {

    override fun insertMyPicture(thePicture: ThePicture, sensations: String) {
        var myPicture: MyPictureEntity?
        val url = thePicture.url

        if (url.isNotEmpty()) {
            myPicture = getMyPictureByUrl(url)

            when {
                myPicture == null -> {
                    myPicture = convertDomainInToMyPictures(thePicture)
                    myPicture.sensations = sensations
                    MyPicturesDB.instance.mypicturesDAO().insert(myPicture)
                    view.showMessage("Imagem adicionada com SUCESSO!")
                    view.onBackPressed()
                }
                sensations != myPicture.sensations -> {
                    MyPicturesDB.instance.mypicturesDAO().delete(myPicture)
                    myPicture.sensations = sensations
                    MyPicturesDB.instance.mypicturesDAO().insert(myPicture)
                    view.showMessage("Sensations foi editada com SUCESSO.")
                }
                else -> view.showMessage("Atenção! Imagem já Existe")
            }
        }
    }

    override fun getMyPictureByUrl(url: String): MyPictureEntity? {
        return MyPicturesDB.instance.mypicturesDAO().getByUrl(url)
    }

    override fun getSensations(url: String): String {
        val picture: MyPictureEntity? = getMyPictureByUrl(url)
        return when {
            picture != null -> picture.sensations
            else -> ""
        }
    }

    private fun convertDomainInToMyPictures(thePicture: ThePicture): MyPictureEntity {
        val myPicture = MyPictureEntity()

        myPicture.url = thePicture.url
        myPicture.name = thePicture.name
        myPicture.favorite = true
        myPicture.sensations = ""
        return myPicture
    }

    override fun deletePicture(url: String) {
        val myPicture = getMyPictureByUrl(url)
        if (myPicture != null) {
            MyPicturesDB.instance.mypicturesDAO().delete(myPicture)
            view.showMessage("Imagem retirada de My Gallery")
        } else
            view.showMessage("Imagem retirada de My Gallery")
    }
}