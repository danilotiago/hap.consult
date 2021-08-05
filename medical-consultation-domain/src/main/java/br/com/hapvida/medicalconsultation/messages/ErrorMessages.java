package br.com.hapvida.medicalconsultation.messages;

public class ErrorMessages {

    public static final String VETERINARY_INACTIVE = "O veterinário esta inativo";
    public static final String VETERINARY_DELETED = "O veterinário esta deletado";
    public static final String VETERINARY_REQUIRED = "O veterinário é obrigatório";
    public static final String VETERINARY_CODE_REQUIRED = "O código do veterinário é obrigatório";
    public static final String VETERINARY_NOT_FOUND = "Veterinário não encontrado";

    public static final String TUTOR_REQUIRED = "O tutor é obrigatório";
    public static final String TUTOR_CODE_REQUIRED = "O código do tutor é obrigatório";
    public static final String TUTOR_NOT_FOUND = "Tutor não encontrado";

    public static final String ANIMAL_INACTIVE = "O animal esta inativo";
    public static final String ANIMAL_DELETED = "O animal esta deletado";
    public static final String ANIMAL_REQUIRED = "O animal é obrigatório";
    public static final String ANIMAL_CODE_REQUIRED = "O código do animal é obrigatório";
    public static final String ANIMAL_NOT_FOUND = "Animal não encontrado";

    public static final String CONSULT_REQUIRED = "A consulta é obrigatória";
    public static final String CONSULT_EXISTS = "Já existe uma consulta marcada para este animal e este veterinário";
    public static final String CANCEL_TODAY_CONSULT = "Uma consulta marcada para hoje não pode ser cancelada";

    public static final String DATE_REQUIRED = "A data do agendamento é obrigatório";

}
