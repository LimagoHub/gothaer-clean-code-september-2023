package de.limago.simplebatch01.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @Override
    public void run(final String... args) throws Exception {
        //JobExecution je1 = jobLauncher.run( job, new JobParameters() );
        //JobExecution je1 = jobLauncher.run( job, new JobParametersBuilder().addString( "InputDateiPfad", "src/main/resources/BeispielDaten2.csv" ).toJobParameters() );
        //System.out.println(je1.getStatus());
    }
}
