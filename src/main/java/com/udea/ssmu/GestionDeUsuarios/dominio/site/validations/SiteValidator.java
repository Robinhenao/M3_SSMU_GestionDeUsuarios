package com.udea.ssmu.GestionDeUsuarios.dominio.site.validations;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteRegistrationData;

public interface SiteValidator {
    public void validate(SiteRegistrationData data);
}
