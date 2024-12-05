package com.example.jooqtest.film

import org.springframework.stereotype.Service

@Service
class FilmService(
    private val filmRepository: FilmRepository
) {

    fun getFilmActorPageResponse(page: Long, pageSize: Long): FilmWithActorPagedResponse {
        val findFilmWithActorList = filmRepository.findFilmWithActorList(page, pageSize)
        val pagedResponse = PagedResponse(page, pageSize)
        return FilmWithActorPagedResponse(pagedResponse, findFilmWithActorList)
    }

    fun getFilmCategoryPageResponse(page: Long, pageSize: Long): FilmWithCategoriesResponse {
        val findFilmWithCategories = filmRepository.findFilmWithCategories(page, pageSize)
        val pagedResponse = PagedResponse(page, pageSize)
        return FilmWithCategoriesResponse(pagedResponse, findFilmWithCategories)
    }
}