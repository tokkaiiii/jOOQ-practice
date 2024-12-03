package com.example.jooqtest.film

import org.springframework.stereotype.Service

@Service
class FilmService(
    private val filmRepository: FilmRepository
) {

    fun getFilmActorPageResponse(page: Long, pageSize: Long): FilmWithActorPagedResponse {
        val findFilmWithActorList = filmRepository.findFilmWithActorList(page, pageSize)
        println(findFilmWithActorList.stream().forEach { println(it.getFilmId()) })
        val pagedResponse = PagedResponse(page, pageSize)
        return FilmWithActorPagedResponse(pagedResponse, findFilmWithActorList)
    }

}