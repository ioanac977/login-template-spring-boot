package com.planning.licenta.service.impl;


import com.planning.licenta.dao.UserDAO;
import com.planning.licenta.entities.User;
import com.planning.licenta.model.UserDTO;
import com.planning.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;
   // private CaregiverDao caregiverDao;

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        //userDao.findAll().iterator().forEachRemaining(list::add);
        return userDao.findAll();
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }


//@PersistenceContext
//private EntityManager entityManager;
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public  List<User> findByCaregiver_idCaregiver(Caregiver caregiver) {
//
//        return this.entityManager.
//                createQuery("select e from user e where e.user_id like '"+caregiver.getId()+"'").
//                getResultList();
//        List<User> list = new ArrayList<>();
//
//        userDao.findByCaregiver(caregiver).iterator().forEachRemaining(list::add);
//
//        Optional<Caregiver> optionalCaregiver = caregiverDao.findById(caregiver.getId());
//        caregiver = optionalCaregiver.isPresent() ? optionalCaregiver.get() : null;
//        if (caregiver != null) {
//            return (List<User>) userDao.findByCaregiver(caregiver);
//        }
//        return null;

    //  }


    @Override
    public User findById(int id) {
        Optional<User> optionalUser = userDao.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public User findByUsername(String username,String password) {
        User findUser =  userDao.findByUsername(username);
        User findUser2 =  new User();
        findUser2.setPassword(findUser.getPassword());
        findUser2.setUsername(findUser.getUsername());


        if (findUser !=null){

            if(password.compareTo(findUser.getPassword())==0)
            {
                return findUser;
            }

        }
        else {
            return null;
        }
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDto) {
        return null;
    }

    @Override
    public User findByIdPatient(String idPatient) {
        return null;
    }

//    @Override
//    public  User findByIdPatient(String idPatient){
//        User findUser =  userDao.findByIdPatient(idPatient);
//        if (findUser !=null){
//            return findUser;
//        }
//        return null;
//    }

//    @Override
//    public UserDto update(UserDto userDto) {
//        User user = findById(userDto.getId());
//        if (user != null) {
//            BeanUtils.copyProperties(userDto, user, "password", "username");
//            userDao.save(user);
//        }
//        return userDto;
//    }

    @Override
    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());

        return userDao.save(newUser);
    }
}
