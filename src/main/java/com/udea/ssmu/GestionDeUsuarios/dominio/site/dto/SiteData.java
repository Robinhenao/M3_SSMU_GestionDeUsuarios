package com.udea.ssmu.GestionDeUsuarios.dominio.site.dto;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.Site;

public record SiteData(
        Long siteCode,
        Long userCode,
        String name,
        String address,
        Long icon
) {
    public SiteData(Site site) {
        this(site.getSiteCode(), site.getUser().getUserCode(), site.getName(), site.getAddress(), site.getIcon());
    }
}
