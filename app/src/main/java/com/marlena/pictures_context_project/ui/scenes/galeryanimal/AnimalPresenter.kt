package com.marlena.pictures_context_project.ui.scenes.galeryanimal

import com.marlena.pictures_context_project.ui.core.App
import com.marlena.pictures_context_project.ui.model.PictureResponse
import com.marlena.pictures_context_project.ui.model.ThePicture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class AnimalPresenter(private val view: Animal.View): Animal.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun getCatsList(){
        launch {
            val result = withContext(Dispatchers.IO) {
                App.pictureRepository.getCatsList()
            }
            if (result.isNullOrEmpty()) view.displayFailure(1)
            else view.setAllList(result)
        }
    }
}






//    //pega a lista de raças
//    override fun getBreeds(): List<String>?{
//        val call = TheCatClient().getService().getBreeds()
//
//        call.enqueue(object: Callback<List<String>> {
//
//            override fun onFailure(call: Call<List<String>>, t: Throwable) {
//                view.displayFailure(R.string.error_get_breeds)
//            }
//
//            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
//                //breedList não é PictureResponse.message é lista de raças
//                breedsList = response.body()
//            }
//        })
//        return breedsList
//    }
//
//    override fun getAllList() = thePictureList
//
//    //Imagem aleatória de dog
//    override fun getRandomDogImage(){
//
//    }
//
//    //lista de imagens por raça
//    override fun getImagesByBreed(breed: String){
////
////        val call = TheCatClient().getService().getBreeds()
////
////        call.enqueue(object: Callback<List<String>> {
////
////            override fun onFailure(call: Call<List<String>>, t: Throwable) {
////                view.displayFailure(R.string.error_get_breeds)
////            }
////
////            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
////                //breedList não é PictureResponse.message é lista de raças
////                val breedsList = response.body()?.map {
////                    PictureResponse(message = it, status = "success")
////                } ?: listOf()
////
////            }
////        })
////        }
////        thePictureList = convertResponseInPictureList(breedsList)
//    }
//
//    //pega raça aleatória dá lista de imagens
//    override fun handleGetBreed(all: String){
//        val breedsListAllImages: MutableList<String>
//        val call = TheCatClient().getService().handleGetBreed(all)
//
//        call.enqueue(object: Callback<PictureResponse> {
//
//            override fun onFailure(call: Call<PictureResponse>, t: Throwable) {
//                view.displayFailure(R.string.error_get_breeds)
//            }
//
//            override fun onResponse(call: Call<PictureResponse>, response: Response<PictureResponse>) {
//                //breedList não é PictureResponse.message é lista de raças
//                response.body()
//            }
//        })
//        return breedsList
//    }
//
//    override fun convertResponseInPictureList(: ArrayList<ThePicture> {
//        var position = 0
//        lateinit var pictureList: ArrayList<ThePicture>
//
//        breedsList?.forEach {
//            pictureList.forEach{
//                breedsList.split(",", true, 0)
//            }

//            pictureList.add(picture)

//            val picture = ThePicture(url = it.message, name = it.status, posterPath = it.message + it.status)
//            pictureList.add(picture)
//        }
//
//        return pictureList
//    }

//    override fun getAllList (breedsList: List<String>?): ArrayList<ThePicture>{
////        thePictureList = PictureClient
//        return thePictureList
//    }
//    }

//    override fun getAllList(): ArrayList<ThePicture> {
//
//        thePictureList = arrayListOf(
//            ThePicture(
//                url = "https://image-store.slidesharecdn.com/6d8bec77-43fa-4a9f-b183-e70fa8197397-original.jpeg",
//                name = "FurtaCor"
//            ),
//            ThePicture(
//                url = "https://www.photoblog.com/learn/wp-content/uploads/2018/10/mark-harpur-748500-unsplash.jpg",
//                name = "Paz Roxa"
//            ),
//            ThePicture(
//                url = "https://img.youtube.com/vi/4Ait-d7106E/hqdefault.jpg",
//                name = "Lindo Por do Sol"
//            ),
//            ThePicture(
//                url = "https://www.check24.ge/storage/tour/45/gallery/y8jh7-1562770737-EdBjx.jpg",
//                name = "Cachoeira"
//            ),
//            ThePicture(
//                url = "https://i.pinimg.com/originals/8b/50/40/8b50400baee33141b7911730b7e7628c.jpg",
//                name = "Envolvente e caloroso"
//            ),
//            ThePicture(
//                url = "https://img.freepik.com/foto-gratis/paisaje-hielo_1048-4465.jpg?size=626&ext=jpg",
//                name = "Gelo e serenidade"
//            ),
//            ThePicture(
//                url = "https://static.dir.bg/uploads/images/2018/09/25/1549458/768x432.jpg?_=1537867612",
//                name = "Inspirador e verde"
//            ),
//            ThePicture(
//                url = "https://i.pinimg.com/236x/a0/16/94/a01694c60570b8dbb10f580f99cef9d8--park-benches-dark-night.jpg",
//                name = "Banco e luz"
//            ),
//            ThePicture(
//                url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVnn4-NxF3PDm1v6-h-eruMXn9ehdack7EJTrWnYgT7WzLZGHP&s",
//                name = "Reflexo árvore vermelha"
//            ),
//            ThePicture(
//                url = "http://i.imgur.com/Tc1Mb.jpg",
//                name = "Reflexo árvore verde"
//            ),//10
//            ThePicture(
//                url = "https://cdn2.outdoorphotographer.com/2019/01/Moody_Landscapes_1.jpg",
//                name = "Tree"
//            ),
//            ThePicture(
//                url = "https://q-xx.bstatic.com/images/hotel/max1024x768/394/39421590.jpg",
//                name = "Girrafe"
//            ),
//            ThePicture(
//                url = "https://33bopn2vwq9l20z09k1ikaal-wpengine.netdna-ssl.com/wp-content/uploads/2010/06/canada_3081-copy-1280x630.jpg",
//                name = "Purple river"
//            ),
//            ThePicture(
//                url = "https://i2.wp.com/digital-photography-school.com/wp-content/uploads/2014/10/Canadian-Rockies-DL1_2975-LR.jpg?resize=600%2C382&ssl=1",
//                name = "Minha fazenda"
//            ),
//            ThePicture(
//                url = "https://landscapephotographymagazine.com/wp-content/gallery/slideshow/12.jpg",
//                name = "Envolvente"
//            ),
//            ThePicture(
//                url = "https://cdn.newsapi.com.au/image/v1/5b2baa308e87de3944d49f8a4c1ca11e?width=650",
//                name = "Vulcan Landscape"
//            ),
//            ThePicture(
//                url = "https://photographycourse.net/wp-content/uploads/2014/11/Landscape-Photography-steps.jpg",
//                name = "Inspirador e girasois"
//            ),
//            ThePicture(
//                url = "https://img2.goodfon.com/wallpaper/nbig/a/24/nature-landscape-scenery-sky-3298.jpg",
//                name = "Ocean"
//            ),
//            ThePicture(
//                url = "http://www.liberaldictionary.com/wp-content/uploads/2019/02/belau-9078.jpg",
//                name = "Beautifull"
//            ),
//            ThePicture(
//                url = "https://www.goodfreephotos.com/albums/other-landscapes/submarine-surfacing-with-mountains-in-the-landscape.jpg",
//                name = "Submarine"
//            )
//        )
//        return thePictureList
//    }
//}