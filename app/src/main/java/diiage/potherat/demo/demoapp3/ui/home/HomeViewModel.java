package diiage.potherat.demo.demoapp3.ui.home;

import android.app.Activity;
import android.app.ActivityManager;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import diiage.potherat.demo.demoapp3.dal.repository.QuoteRepository;
import diiage.potherat.demo.demoapp3.model.Quote;

public class HomeViewModel extends ViewModel {

    private QuoteRepository quoteRepository;

    @Inject
    @ViewModelInject
    public HomeViewModel(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public LiveData<String> getNumberOfQuotes() {
        return Transformations.map(quoteRepository.getNumberOfQuotes(), quote -> {
            return quote.toString();
        });
    }

    public LiveData<String> getDistinctSources() {
        return Transformations.map(quoteRepository.getDistinctSources(), source -> {
            return source.toString();
        });
        // return quoteRepository.getDistinctSources();
    }

    public LiveData<Quote> getLastQuote() {
        return quoteRepository.getLastQuote();
    }
}