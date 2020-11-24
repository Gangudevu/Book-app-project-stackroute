package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.model.Favourites;

public interface FavouritesService {
		public void deleteById(String favId);

		public Favourites addToFavourites(Favourites favObj);
		public List<Favourites> getAllFavouritesByEmail(String email);
		public Favourites getFavouritesByEmailAndBookId(String email, String bookId);
}
