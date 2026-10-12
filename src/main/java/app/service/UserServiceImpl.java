package app.service;

import app.domain.User;
import app.service.inputports.UserService;
import app.service.outputports.UserRepository;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor — NO lo cambies
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(Integer id, String name, String lastName, String email,
                       String phone, String password, String state, String city,
                       String preferences) {
        User user = new User(id, name, lastName, email, phone, password,
                state, city, preferences);
        return userRepository.save(user);
    }

    @Override
    public void selectById(int id) {
        User encontrado = userRepository.selectById(id);
        if (encontrado != null) {
            System.out.println(" Usuario encontrado:");
            System.out.println("ID: " + encontrado.getId());
            System.out.println("Nombre: " + encontrado.getName() + " " + encontrado.getLastName());
            System.out.println("Email: " + encontrado.getEmail());
            System.out.println("Ciudad: " + encontrado.getCity());
        } else {
            System.out.println(" Usuario con ID " + id + " no existe");
        }
    }

    @Override
    public void update() {
        System.out.println("ℹ Actualizando usuario...");
    }

    @Override
    public List<User> selectUsers() {
        return userRepository.selectAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public int countTotalUsers() {
        return userRepository.countTotalUsers();
    }
}