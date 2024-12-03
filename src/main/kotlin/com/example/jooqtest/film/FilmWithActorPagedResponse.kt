package com.example.jooqtest.film

class FilmWithActorPagedResponse(
    val pagedResponse: PagedResponse,
    findFilmWithActorList: List<FilmWithActor>
) {

     val filmActorList: List<FilmActorResponse> =
        findFilmWithActorList.stream().map { FilmActorResponse(it) }.toList()

    class FilmActorResponse(
        private val filmWithActor: FilmWithActor
    ){
        val filmTitle = filmWithActor.getTitle()
        val actorFullName = filmWithActor.getActorFullName()
        val filmId = filmWithActor.getFilmId()
    }
}
