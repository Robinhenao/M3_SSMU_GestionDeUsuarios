package com.udea.ssmu.GestionDeUsuarios.dominio.site;



import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteData;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.interfaces.SiteService;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.validations.SiteValidator;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserRepository;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.CustomValidationException;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.DataIntegrityValidationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    private SiteRepository siteRepository;
    private UserRepository userRepository;
    private List<SiteValidator> validators;
    public SiteServiceImpl(SiteRepository siteRepository,List<SiteValidator> validators, UserRepository userRepository){
        this.siteRepository = siteRepository;
        this.validators = validators;
        this.userRepository = userRepository;
    }
    @Override
    public List<SiteData> getSitesByUser(Long userCode) {
        List<Site> sites = this.siteRepository.findAllByUser_UserCode(userCode);
        return sites.stream().map(SiteData::new).toList();
    }

    @Override
    public void deleteSite(Long siteCode) {
        this.siteRepository.deleteById(siteCode);
    }

    @Override
    public SiteData registerSite(SiteRegistrationData siteRegistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();
        validators.forEach(v -> {
            try {
                v.validate(siteRegistrationData);
            }catch (CustomValidationException e){
                exceptions.add(e);
            }
        });
        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }

        User user = this.userRepository.getReferenceById(siteRegistrationData.userCode());

        Site site = new Site(
                siteRegistrationData.name(),
                siteRegistrationData.address(),
                siteRegistrationData.icon(),
                user);
        site = this.siteRepository.save(site);
        return new SiteData(site);
    }

    @Override
    public SiteData getSite(Long siteCode) {
        Site site = this.siteRepository.getReferenceById(siteCode);;
        return new SiteData(site);
    }
}
