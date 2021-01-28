package diiage.potherat.demo.demoapp3.dal.repository;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingSource;
import androidx.room.Query;

import diiage.potherat.demo.demoapp3.model.Quote;

public interface QuoteRepository {
    PagingSource<Integer, Quote> getAll();
    LiveData<Quote> getById(Long id);

    LiveData<Integer> getNumberOfQuotes();
    LiveData<Integer> getDistinctSources();
    LiveData<Quote> getLastQuote();

    Long create(Quote quote);
    void update(Quote quote);
    void delete(Quote quote);
}
