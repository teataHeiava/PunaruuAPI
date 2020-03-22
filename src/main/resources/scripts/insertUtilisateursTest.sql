INSERT INTO public.bureau (id, date_election, date_fin, version, section_id) VALUES (1, '2020-01-01', '2021-01-31', '2020-03-21 22:02:33.693000', 1);

INSERT INTO public.personne (id, adresse_geographique, date_naissance, nom, prenom, telehone_fixe, telephone_portable, version, commune_id) VALUES (2, 'chez lui', '1969-12-31', 'TEATA', 'Heiava', null, null, '2020-03-21 22:02:33.693000', 115);
INSERT INTO public.dirigeant (date_fin, fonction, identifiant, password, id, bureau_id) VALUES ('2020-03-21', 'PRESIDENT', 'heiava', 'toto', 2, 1);

INSERT INTO public.personne (id, adresse_geographique, date_naissance, nom, prenom, telehone_fixe, telephone_portable, version, commune_id) VALUES (1, 'chez titi', '1969-12-31', 'GATIEN', 'FANAU alias RAERAE', null, null, '2020-03-21 22:02:33.693000', 115);
INSERT INTO public.dirigeant (date_fin, fonction, identifiant, password, id, bureau_id) VALUES ('2020-03-21', 'SECRETAIRE', 'fafa', 'toto', 1, 1);