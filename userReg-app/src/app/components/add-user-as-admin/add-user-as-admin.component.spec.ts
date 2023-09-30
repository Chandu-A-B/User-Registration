import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUserAsAdminComponent } from './add-user-as-admin.component';

describe('AddUserAsAdminComponent', () => {
  let component: AddUserAsAdminComponent;
  let fixture: ComponentFixture<AddUserAsAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUserAsAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddUserAsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
