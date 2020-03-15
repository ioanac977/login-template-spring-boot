package com.planning.licenta.service.impl;

import com.planning.licenta.dao.RegisteredUserDAO;
import com.planning.licenta.dao.UserDAO;
import com.planning.licenta.entities.RegisteredUser;
import com.planning.licenta.entities.User;
import com.planning.licenta.model.RegisteredUserDTO;
import com.planning.licenta.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "registeredRegisteredUserService")
public class RegisteredUserServiceImpl implements RegisteredUserService {

    @Autowired
    private RegisteredUserDAO registeredRegisteredUserDao;

    @Autowired
    private UserDAO userDAO;
    // private CaregiverDao caregiverDao;

    public List<RegisteredUser> findAll() {
        List<RegisteredUser> list = new ArrayList<>();
        //registeredRegisteredUserDao.findAll().iterator().forEachRemaining(list::add);
        return registeredRegisteredUserDao.findAll();
    }

    @Override
    public void delete(int id) {
        registeredRegisteredUserDao.deleteById(id);
    }


//@PersistenceContext
//private EntityManager entityManager;
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public  List<RegisteredUser> findByCaregiver_idCaregiver(Caregiver caregiver) {
//
//        return this.entityManager.
//                createQuery("select e from registeredRegisteredUser e where e.registeredRegisteredUser_id like '"+caregiver.getId()+"'").
//                getResultList();
//        List<RegisteredUser> list = new ArrayList<>();
//
//        registeredRegisteredUserDao.findByCaregiver(caregiver).iterator().forEachRemaining(list::add);
//
//        Optional<Caregiver> optionalCaregiver = caregiverDao.findById(caregiver.getId());
//        caregiver = optionalCaregiver.isPresent() ? optionalCaregiver.get() : null;
//        if (caregiver != null) {
//            return (List<RegisteredUser>) registeredRegisteredUserDao.findByCaregiver(caregiver);
//        }
//        return null;

    //  }


    @Override
    public RegisteredUser findById(int id) {
        Optional<RegisteredUser> optionalRegisteredUser = registeredRegisteredUserDao.findById(id);
        return optionalRegisteredUser.isPresent() ? optionalRegisteredUser.get() : null;
    }

    @Override
    public RegisteredUser findByRegisteredUsername(String registeredUsername, String password) {
        return null;
    }

//    @Override
//    public RegisteredUser findByRegisteredUsername(String registeredRegisteredUsername,String password) {
//        RegisteredUser findRegisteredUser =  registeredRegisteredUserDao.findByRegisteredUsername(registeredRegisteredUsername);
//        RegisteredUser findRegisteredUser2 =  new RegisteredUser();
//        findRegisteredUser2.setPassword(findRegisteredUser.getPassword());
//        findRegisteredUser2.setRegisteredUsername(findRegisteredUser.getRegisteredUsername());
//
//
//        if (findRegisteredUser !=null){
//
//            if(password.compareTo(findRegisteredUser.getPassword())==0)
//            {
//                return findRegisteredUser;
//            }
//
//        }
//        else {
//            return null;
//        }
//        return null;
//    }

    @Override
    public RegisteredUserDTO update(RegisteredUserDTO registeredRegisteredUserDto) {
        return null;
    }

    @Override
    public RegisteredUser findByIdPatient(String idPatient) {
        return null;
    }

//    @Override
//    public  RegisteredUser findByIdPatient(String idPatient){
//        RegisteredUser findRegisteredUser =  registeredRegisteredUserDao.findByIdPatient(idPatient);
//        if (findRegisteredUser !=null){
//            return findRegisteredUser;
//        }
//        return null;
//    }

//    @Override
//    public RegisteredUserDto update(RegisteredUserDto registeredRegisteredUserDto) {
//        RegisteredUser registeredRegisteredUser = findById(registeredRegisteredUserDto.getId());
//        if (registeredRegisteredUser != null) {
//            BeanUtils.copyProperties(registeredRegisteredUserDto, registeredRegisteredUser, "password", "registeredRegisteredUsername");
//            registeredRegisteredUserDao.save(registeredRegisteredUser);
//        }
//        return registeredRegisteredUserDto;
//    }

    @Override
    public RegisteredUser save(RegisteredUserDTO registeredRegisteredUser) {
        RegisteredUser newRegisteredUser = new RegisteredUser();
        newRegisteredUser.setFirstName(registeredRegisteredUser.getFirstName());
        newRegisteredUser.setLastName(registeredRegisteredUser.getLastName());
        newRegisteredUser.setAddress(registeredRegisteredUser.getAddress());

        User userNou = new User();
        // userNou.setUsername(caregiver.getUser().getUsername());
        userNou =  userDAO.findByUsername(registeredRegisteredUser.getUser().getUsername());
//        Users userLocal = new Users();
//        userLocal.setId(caregiver.getUser().getId());
        newRegisteredUser.setUser(userNou);
        // newCaregiver.setPatientsList(caregiver.getPatients());

//        newRegisteredUser.se.setCaregiver_idCaregiver(localCaregiver);

        return registeredRegisteredUserDao.save(newRegisteredUser);
    }
}