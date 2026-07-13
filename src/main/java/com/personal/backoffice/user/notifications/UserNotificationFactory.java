package com.personal.backoffice.user.notifications;

import com.personal.backoffice.user.entities.User;
import com.personal.shared.notifications.Notification;

public class UserNotificationFactory {

    public static Notification CreateUserFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el usuario. ");
    }

    public static Notification CreateUserSuccess() {
        return new Notification("El usuario fue creado exitosamente.");
    }

    public static Notification CreateUserCredentialsFail() {
        return new Notification("Ha ocurrido un error mientras se creaban las credenciales del usuario. ");
    }

    public static Notification CreateUserCredentialsSuccess() {
        return new Notification("Las credenciales del usuario fueron creadas exitosamente.");
    }

    public static Notification UpdateUserSuccess() {
        return new Notification("El usuario fue actualizado exitosamente.");
    }

    public static Notification UpdateUserFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el usuario ");
    }

    public static Notification UserValidationFail(User user) {
        return new Notification("Ha ocurrido un error de validación, mientras se creaba el usuario " + user.getNames());
    }

    public static Notification FetchUserEmpty(String filter) {
        return new Notification("No existen usuarios con los criterios de búsqueda: " + filter);
    }

    public static Notification FetchUserSuccess() {
        return new Notification("Lista de usuarios");
    }

    public static Notification FetchUserFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los usuarios");
    }

    public static Notification LoginFail(User user) {
        return new Notification("El usuario " + user.getEmail() + " no existe o la contraseña es incorrecta.");
    }

    public static Notification AssociateUserClientFail() {
        return new Notification("Ha ocurrido un error mientras se asociaba el cliente al usuario.");
    }

    public static Notification AssociateUserClientSuccess() {
        return new Notification("El cliente fue asociado exitosamente al usuario.");
    }

    public static Notification DeleteAssociatedUserClientFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la relación Cliente, Usuario.");
    }

    public static Notification DeleteAssociatedUserClientSuccess() {
        return new Notification("La relación Cliente, Usuario. Ha sido eliminada exitosamente");
    }

    public static Notification FetchAssociatedUserClientEmpty(String filter) {
        return new Notification("No existen clientes asociados a este usuarios con los criterios de búsqueda: " + filter);
    }

    public static Notification FetchAssociatedUserClientSuccess() {
        return new Notification("Lista de clientes asociados al usuario.");
    }

    public static Notification FetchAssociatedUserClientFail() {
        return new Notification("Ha ocurrido un error mientras se obtenían los clientes asociados al usuario.");
    }

    public static Notification UpdateAssociatedUserClientSuccess() {
        return new Notification("Se ha actualizado exitosamente, el cliente asociado al usuario.");
    }

    public static Notification UpdateAssociatedUserClientFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el cliente asociado al usuario.");
    }

    public static Notification AssociateUserBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se asociaba la empresa al usuario.");
    }

    public static Notification AssociateUserBusinessSuccess() {
        return new Notification("La empresa fue asociada exitosamente al usuario.");
    }

    public static Notification DeleteAssociatedUserBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la relación Empresa, Usuario.");
    }

    public static Notification DeleteAssociatedUserBusinessSuccess() {
        return new Notification("La relación Empresa, Usuario. Ha sido eliminada exitosamente");
    }

    public static Notification FetchAssociatedUserBusinessEmpty(String filter) {
        return new Notification("No existen empresas asociadas a este usuarios con los criterios de búsqueda: " + filter);
    }

    public static Notification FetchAssociatedUserBusinessSuccess() {
        return new Notification("Lista de empresas asociadas al usuario.");
    }

    public static Notification FetchAssociatedUserBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se obtenían las empresas asociadas al usuario.");
    }

    public static Notification UpdateAssociatedUserBusinessSuccess() {
        return new Notification("Se ha actualizado exitosamente, la empresa asociada al usuario.");
    }

    public static Notification UpdateAssociatedUserBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la empresa asociada al usuario.");
    }
}
