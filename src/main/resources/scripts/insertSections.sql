alter sequence section_id_seq restart 1;
delete FROM section;
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('BUR', current_date, 'GRANDBUREAU', 'Grand bureau Tamarii Punaruu', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('FOO', current_date, 'FOOTBALL', 'Section Football', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('VAA', current_date, 'VAA', 'Section Vaa', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('TKW', current_date, 'TAEKWONDO', 'Section Tae kwon do', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('PET', current_date, 'PETANQUE', 'Section pétanque', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('NAT', current_date, 'NATATION', 'Section natation', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('ATH', current_date, 'ATHLETISME', 'Section athlétisme', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('BAB', current_date, 'BASKETBALL', 'Section basket-ball', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('VOB', current_date, 'VOLLEYBALL', 'Section volley-ball', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('TIR', current_date, 'BALLTRAP', 'Section ball-trap', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('KTE', current_date, 'KARATE', 'Section karate', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('HDB', current_date, 'HANDBALL', 'Section handball', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('MUS', current_date, 'MUSCULATION', 'Section musculation', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('TRI', current_date, 'TRIATHLON', 'Section triathlon', null, 'CIVILE', current_date);
insert into section (code, date_validation_catp, discipline, nom, reglement_interieur, type_calendrier, version)
values ('CYC', current_date, 'CYCLISME', 'Section cyclisme', null, 'CIVILE', current_date);