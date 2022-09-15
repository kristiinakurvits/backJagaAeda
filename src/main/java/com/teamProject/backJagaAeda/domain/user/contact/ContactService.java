package com.teamProject.backJagaAeda.domain.user.contact;

import com.teamProject.backJagaAeda.application.login.RegisterRequest;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private UserService userService;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;


    public Contact registerRequestToContact(RegisterRequest request) {
        Contact contact = contactMapper.registerRequestToContact(request);
        contactRepository.save(contact);
        return contact;
    }

//    public List<ContactInfo>updateContactInfosWithUserIds(List<Contact> contacts) {
//        List<ContactInfo> contactInfos = contactMapper.contactsToContactInfos(contacts);
//        userService.updateContactInfosWithUserIds(contactInfos);
//        return contactInfos;
//    }



}
