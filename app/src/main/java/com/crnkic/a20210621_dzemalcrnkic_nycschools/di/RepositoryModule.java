package com.crnkic.a20210621_dzemalcrnkic_nycschools.di;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.network.GetDataService;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.repository.SchoolsRepository;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.repository.SchoolsRepositoryImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public static SchoolsRepositoryImp provideSchoolRepository(GetDataService getDataService) {
        return new SchoolsRepository(getDataService);
    }
}
