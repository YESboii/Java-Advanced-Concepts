package proxy.app;

import proxy.framework.Component;
import proxy.framework.Transactional;

@Component
public class DefaultCustomerServiceImpl implements CustomerService{

    @Override
    @Transactional
    public void saveAndUploadImage(String name) {
        System.out.println("Saving %s...".formatted(name));
        System.out.println("uploading %s...".formatted(name));
    }

    @Override
    public void readAll() {
        System.out.println("Reading from Db ..");
    }
}
