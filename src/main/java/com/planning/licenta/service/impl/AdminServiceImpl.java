package com.planning.licenta.service.impl;

import com.planning.licenta.dao.AdminDAO;
import com.planning.licenta.dao.UserDAO;
import com.planning.licenta.entities.Admin;
import com.planning.licenta.entities.User;
import com.planning.licenta.model.AdminDTO;
import com.planning.licenta.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "registeredAdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO registeredAdminDao;
    @Autowired
    private UserDAO userDAO;
    // private CaregiverDao caregiverDao;

    public List<Admin> findAll() {
        List<Admin> list = new ArrayList<>();
        //registeredAdminDao.findAll().iterator().forEachRemaining(list::add);
        return registeredAdminDao.findAll();
    }

    @Override
    public void delete(int id) {
        registeredAdminDao.deleteById(id);
    }


//@PersistenceContext
//private EntityManager entityManager;
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public  List<Admin> findByCaregiver_idCaregiver(Caregiver caregiver) {
//
//        return this.entityManager.
//                createQuery("select e from registeredAdmin e where e.registeredAdmin_id like '"+caregiver.getId()+"'").
//                getResultList();
//        List<Admin> list = new ArrayList<>();
//
//        registeredAdminDao.findByCaregiver(caregiver).iterator().forEachRemaining(list::add);
//
//        Optional<Caregiver> optionalCaregiver = caregiverDao.findById(caregiver.getId());
//        caregiver = optionalCaregiver.isPresent() ? optionalCaregiver.get() : null;
//        if (caregiver != null) {
//            return (List<Admin>) registeredAdminDao.findByCaregiver(caregiver);
//        }
//        return null;

    //  }


    @Override
    public Admin findById(int id) {
        Optional<Admin> optionalAdmin = registeredAdminDao.findById(id);
        return optionalAdmin.isPresent() ? optionalAdmin.get() : null;
    }


//    @Override
//    public Admin findByAdminname(String registeredAdminname,String password) {
//        Admin findAdmin =  registeredAdminDao.findByAdminname(registeredAdminname);
//        Admin findAdmin2 =  new Admin();
//        findAdmin2.setPassword(findAdmin.getPassword());
//        findAdmin2.setAdminname(findAdmin.getAdminname());
//
//
//        if (findAdmin !=null){
//
//            if(password.compareTo(findAdmin.getPassword())==0)
//            {
//                return findAdmin;
//            }
//
//        }
//        else {
//            return null;
//        }
//        return null;
//    }

    @Override
    public AdminDTO update(AdminDTO registeredAdminDto) {
        return null;
    }



//    @Override
//    public  Admin findByIdPatient(String idPatient){
//        Admin findAdmin =  registeredAdminDao.findByIdPatient(idPatient);
//        if (findAdmin !=null){
//            return findAdmin;
//        }
//        return null;
//    }

//    @Override
//    public AdminDto update(AdminDto registeredAdminDto) {
//        Admin registeredAdmin = findById(registeredAdminDto.getId());
//        if (registeredAdmin != null) {
//            BeanUtils.copyProperties(registeredAdminDto, registeredAdmin, "password", "registeredAdminname");
//            registeredAdminDao.save(registeredAdmin);
//        }
//        return registeredAdminDto;
//    }

    @Override
    public Admin save(AdminDTO registeredAdmin) {
        Admin newAdmin = new Admin();
        newAdmin.setFirstName(registeredAdmin.getFirstName());
        newAdmin.setLastName(registeredAdmin.getLastName());

        User userNou = new User();
        // userNou.setUsername(caregiver.getUser().getUsername());
//        userNou =  userDAO.findByUsername(registeredAdmin.getUser().getUsername());
////        Users userLocal = new Users();
////        userLocal.setId(caregiver.getUser().getId());
//        newAdmin.setUser(userNou);
        newAdmin.setUser(registeredAdmin.getUser());


        return registeredAdminDao.save(newAdmin);
    }
}