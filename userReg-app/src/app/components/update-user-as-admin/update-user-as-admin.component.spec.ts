import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUserAsAdminComponent } from './update-user-as-admin.component';

describe('UpdateUserAsAdminComponent', () => {
  let component: UpdateUserAsAdminComponent;
  let fixture: ComponentFixture<UpdateUserAsAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateUserAsAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateUserAsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
