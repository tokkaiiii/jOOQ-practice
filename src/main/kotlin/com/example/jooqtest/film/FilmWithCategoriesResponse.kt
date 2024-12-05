package com.example.jooqtest.film

class FilmWithCategoriesResponse(
    val pagedResponse: PagedResponse,
    findFilmWithCategories: List<FilmWithCategory>
) {

    val filmCategories: List<FilmCategoryResponse> = findFilmWithCategories.stream().map { FilmCategoryResponse(it) }.toList()

    data class FilmCategoryResponse(
        private val filmWithCategory: FilmWithCategory){

        val filmId = filmWithCategory.filmId
        val categoryName = filmWithCategory.categoryName
        val categoryLastUpdate = filmWithCategory.categoryLastUpdate
    }

}
